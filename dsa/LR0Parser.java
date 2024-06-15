import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class LR0Parser {
    static Set<Character> terminalSymbols = new HashSet<>();
    static Map<Character, List<List<Character>>> grammarRules = new HashMap<>();

    static boolean calculateFirst(char i, char org, char last, Map<Character, List<List<Character>>> rules) {
        boolean takeEpsilon = false;
        for (List<Character> rule : rules.get(i)) {
            boolean take = true;
            for (char symbol : rule) {
                if (symbol == i) break;
                if (!take) break;
                if (!(symbol >= 'A' && symbol <= 'Z') && symbol != 'e') {
                    terminalSymbols.add(symbol);
                    break;
                } else if (symbol == 'e') {
                    if (org == i || i == last)
                        terminalSymbols.add(symbol);
                    takeEpsilon = true;
                    break;
                } else {
                    take = calculateFirst(symbol, org, rule.get(rule.size() - 1), rules);
                    takeEpsilon |= take;
                }
            }
        }
        return takeEpsilon;
    }

    static Map<Integer, Map<Character, Set<Pair<Deque<Character>, Deque<Character>>>>> lr0ItemSets = new HashMap<>();
    static Map<Integer, List<Pair<Integer, Character>>> transitions = new HashMap<>();

    static int num = -1;

    static void constructLR0ItemSet(char c, char way, int last, Pair<Deque<Character>, Deque<Character>> curr) {
        Map<Character, Set<Pair<Deque<Character>, Deque<Character>>>> newLr0ItemSet = new HashMap<>();
        int rep = -2;
        if (last != -1) {
            for (Pair<Integer, Character> transition : transitions.get(last)) {
                if (transition.second == way) {
                    rep = transition.first;
                    newLr0ItemSet = lr0ItemSets.get(transition.first);
                }
            }
        }
        newLr0ItemSet.computeIfAbsent(c, k -> new HashSet<>()).add(curr);
        int count = 10;
        while (count-- > 0) {
            for (Map.Entry<Character, Set<Pair<Deque<Character>, Deque<Character>>>> itemSet : newLr0ItemSet.entrySet()) {
                for (Pair<Deque<Character>, Deque<Character>> item : itemSet.getValue()) {
                    if (!item.second.isEmpty()) {
                        if (item.second.peekFirst() >= 'A' && item.second.peekFirst() <= 'Z') {
                            for (List<Character> rule : grammarRules.get(item.second.peekFirst())) {
                                Deque<Character> st = new ArrayDeque<>(), emp = new ArrayDeque<>();
                                for (char symbol : rule) st.addLast(symbol);
                                newLr0ItemSet.computeIfAbsent(item.second.peekFirst(), k -> new HashSet<>()).add(new Pair<>(emp, st));
                            }
                        }
                    }
                }
            }
        }
        for (Map.Entry<Integer, Map<Character, Set<Pair<Deque<Character>, Deque<Character>>>>> existingLr0ItemSet : lr0ItemSets.entrySet()) {
            if (existingLr0ItemSet.getValue().equals(newLr0ItemSet)) {
                transitions.get(last).add(new Pair<>(existingLr0ItemSet.getKey(), way));
                return;
            }
        }
        if (rep == -2) {
            lr0ItemSets.put(++num, newLr0ItemSet);
            if (last != -1)
                transitions.get(last).add(new Pair<>(num, way));
        } else {
            lr0ItemSets.put(rep, newLr0ItemSet);
        }
        int cc = num;
        for (Map.Entry<Character, Set<Pair<Deque<Character>, Deque<Character>>>> itemSet : newLr0ItemSet.entrySet()) {
            for (Pair<Deque<Character>, Deque<Character>> item : itemSet.getValue()) {
                if (!item.second.isEmpty()) {
                    Deque<Character> newFirst = new ArrayDeque<>(item.first);
                    newFirst.addLast(item.second.peekFirst());
                    Deque<Character> newSecond = new ArrayDeque<>(item.second);
                    newSecond.removeFirst();
                    constructLR0ItemSet(itemSet.getKey(), newFirst.peekLast(), cc, new Pair<>(newFirst, newSecond));
                }
            }
        }
    }

    public static void main(String[] args) {
        try (BufferedReader inputFile = new BufferedReader(new FileReader("inputslr.txt"))) {
            String line;
            char startSymbol;
            boolean startSymbolFlag = false;
            System.out.println("Grammar: ");
            while ((line = inputFile.readLine()) != null) {
                if (!startSymbolFlag) {
                    startSymbol = line.charAt(0);
                    startSymbolFlag = true;
                }
                System.out.println(line);
                char symbol = line.charAt(0);
                List<Character> temp = new ArrayList<>();
                for (int i = 3; i < line.length(); i++) {
                    if (line.charAt(i) == '|') {
                        grammarRules.computeIfAbsent(symbol, k -> new ArrayList<>()).add(temp);
                        temp = new ArrayList<>();
                    } else {
                        temp.add(line.charAt(i));
                    }
                }
                grammarRules.computeIfAbsent(symbol, k -> new ArrayList<>()).add(temp);
            }

            Map<Character, Set<Character>> firstSets = new HashMap<>();
            for (Map.Entry<Character, List<List<Character>>> rule : grammarRules.entrySet()) {
                System.out.print(rule.getKey() + " -> ");
                terminalSymbols.clear();
                System.out.println();
                calculateFirst(rule.getKey(), rule.getKey(), rule.getKey(), grammarRules);
                for (char symbol : terminalSymbols) {
                    System.out.print(symbol + ",");
                    firstSets.computeIfAbsent(rule.getKey(), k -> new HashSet<>()).add(symbol);
                }
            }

            System.out.println("\nFIRST: ");
            for (Map.Entry<Character, Set<Character>> set : firstSets.entrySet()) {
                StringBuilder ans = new StringBuilder();
                ans.append(set.getKey()).append(" = {");
                for (char symbol : set.getValue()) {
                    ans.append(symbol).append(',');
                }
                ans.deleteCharAt(ans.length() - 1);
                ans.append("}");
                System.out.println(ans);
            }

            Map<Character, Set<Character>> followSets = new HashMap<>();
            followSets.computeIfAbsent(startSymbol, k -> new HashSet<>()).add('$');
            int count = 10;
            while (count-- > 0) {
                for (Map.Entry<Character, List<List<Character>>> rule : grammarRules.entrySet()) {
                    for (List<Character> production : rule.getValue()) {
                        for (int i = 0; i < production.size() - 1; i++) {
                            if (production.get(i) >= 'A' && production.get(i) <= 'Z') {
                                if (!(production.get(i + 1) >= 'A' && production.get(i + 1) <= 'Z'))
                                    followSets.computeIfAbsent(production.get(i), k -> new HashSet<>()).add(production.get(i + 1));
                                else {
                                    char temp = production.get(i + 1);
                                    int j = i + 1;
                                    while (temp >= 'A' && temp <= 'Z') {
                                        if (firstSets.get(temp).contains('e')) {
                                            for (char symbol : firstSets.get(temp)) {
                                                if (symbol == 'e') continue;
                                                followSets.computeIfAbsent(production.get(i), k -> new HashSet<>()).add(symbol);
                                            }
                                            j++;
                                            if (j < production.size()) {
                                                temp = production.get(j);
                                                if (!(temp >= 'A' && temp <= 'Z')) {
                                                    followSets.computeIfAbsent(production.get(i), k -> new HashSet<>()).add(temp);
                                                    break;
                                                }
                                            } else {
                                                for (char symbol : followSets.get(rule.getKey()))
                                                    followSets.computeIfAbsent(production.get(i), k -> new HashSet<>()).add(symbol);
                                                break;
                                            }
                                        } else {
                                            for (char symbol : firstSets.get(temp))
                                                followSets.computeIfAbsent(production.get(i), k -> new HashSet<>()).add(symbol);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        if (production.get(production.size() - 1) >= 'A' && production.get(production.size() - 1) <= 'Z') {
                            for (char symbol : followSets.get(rule.getKey()))
                                followSets.computeIfAbsent(production.get(i), k -> new HashSet<>()).add(symbol);
                        }
                    }
                }
            }

            System.out.println("\nFOLLOW: ");
            for (Map.Entry<Character, Set<Character>> set : followSets.entrySet()) {
                StringBuilder ans = new StringBuilder();
                ans.append(set.getKey()).append(" = {");
                for (char symbol : set.getValue()) {
                    ans.append(symbol).append(',');
                }
                ans.deleteCharAt(ans.length() - 1);
                ans.append("}");
                System.out.println(ans);
            }

            String start = "." + startSymbol;
            Deque<Character> emptyDeque = new ArrayDeque<>();
            Deque<Character> symbolDeque = new ArrayDeque<>();
            symbolDeque.addLast(startSymbol);
            constructLR0ItemSet('!', 'k', -1, new Pair<>(emptyDeque, symbolDeque));

            System.out.println("\nProductions: ");
            int productionCount = 1;
            Set<Character> actionSymbols = new HashSet<>();
            Set<Character> gotoSymbols = new HashSet<>();
            Map<Pair<Character, Deque<Character>>, Integer> position = new HashMap<>();
            for (Map.Entry<Character, List<List<Character>>> rule : grammarRules.entrySet()) {
                gotoSymbols.add(rule.getKey());
                for (List<Character> production : rule.getValue()) {
                    System.out.print("r" + productionCount + ": ");
                    StringBuilder ans = new StringBuilder();
                    ans.append(rule.getKey()).append("->");
                    Deque<Character> temp = new ArrayDeque<>();
                    for (char symbol : production) {
                        ans.append(symbol);
                        temp.addLast(symbol);
                    }
                    position.put(new Pair<>(rule.getKey(), temp), productionCount);
                    for (char symbol : production) {
                        if (symbol >= 'A' && symbol <= 'Z') gotoSymbols.add(symbol);
                        else actionSymbols.add(symbol);
                    }
                    System.out.println(ans);
                    productionCount++;
                }
            }
            System.out.println("\nGraph: ");
            for (Map.Entry<Integer, Map<Character, Set<Pair<Deque<Character>, Deque<Character>>>>> itemSet : lr0ItemSets.entrySet()) {
            System.out.println();
            System.out.print("I" + itemSet.getKey() + ": \n");
            for (Map.Entry<Character, Set<Pair<Deque<Character>, Deque<Character>>>> set : itemSet.getValue().entrySet()) {
                StringBuilder ans = new StringBuilder();
                ans.append(set.getKey());
                ans.append("->");
                for (Pair<Deque<Character>, Deque<Character>> item : set.getValue()) {
                    for (char symbol : item.first) ans.append(symbol);
                    ans.append('.');
                    for (char symbol : item.second) ans.append(symbol);
                    ans.append('|');
                }
                ans.deleteCharAt(ans.length() - 1);
                for (char symbol : ans.toString().toCharArray()) {
                    if (symbol == '!') System.out.print(startSymbol + '\'');
                    else System.out.print(symbol);
                }
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Edges: ");
        for (Map.Entry<Integer, List<Pair<Integer, Character>>> transition : transitions.entrySet()) {
            for (Pair<Integer, Character> pair : transition.getValue()) {
                System.out.println("I" + transition.getKey() + " -> " + pair.second + " -> " + "I" + pair.first);
            }
        }
        actionSymbols.add('$');
        System.out.println("\nParsing Table:");
        System.out.println("St.\t\tAction & Goto");
        int total = lr0ItemSets.size();
        System.out.print("  \t");
        for (char symbol : actionSymbols) System.out.print(symbol + "\t");
        for (char symbol : gotoSymbols) System.out.print(symbol + "\t");
        System.out.println();
        for (int i = 0; i < total; i++) {
            System.out.print("I" + i + "\t");
            for (char symbol : actionSymbols) {
                if (transitions.containsKey(i)) {
                    int flag = 0;
                    for (Pair<Integer, Character> transition : transitions.get(i)) {
                        if (transition.second == symbol) {
                            flag = 1;
                            System.out.print("S" + transition.first + "\t");
                            break;
                        }
                    }
                    if (flag == 0) System.out.print("-\t");
                } else {
                    int flag = 0;
                    for (Map.Entry<Character, Set<Pair<Deque<Character>, Deque<Character>>>> pair : lr0ItemSets.get(i).entrySet()) {
                        if (pair.getKey() == '!') {
                            if (symbol == '$') {
                                System.out.print("AC\t");
                                flag = 1;
                            } else System.out.print("-\t");
                        }
                    }
                    if (flag == 0) {
                        for (Map.Entry<Character, Set<Pair<Deque<Character>, Deque<Character>>>> pair : lr0ItemSets.get(i).entrySet()) {
                            char c = pair.getKey();
                            Deque<Character> check = pair.getValue().iterator().next().first;
                            int counter = 1;
                            for (char followSymbol : followSets.get(c)) {
                                if (followSymbol == symbol) {
                                    System.out.print("r" + position.get(new Pair<>(c, check)) + "\t");
                                }
                                counter++;
                            }
                        }
                    }
                }
            }
            for (char symbol : gotoSymbols) {
                if (transitions.containsKey(i)) {
                    int flag = 0;
                    for (Pair<Integer, Character> transition : transitions.get(i)) {
                        if (transition.second == symbol) {
                            flag = 1;
                            System.out.print(transition.first + "\t");
                            break;
                        }
                    }
                    if (flag == 0) System.out.print("-\t");
                } else {
                    System.out.print("-\t");
                }
            }
            System.out.println();
        }
    }
}

}
class Pair<T, U> {
    T first;
    U second;

    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

    