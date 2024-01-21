package dsa.Hashmap;
/**
 * Mapusing Hash
 */
public class MapusingHash {

    private Entity[] entities;

    public MapusingHash(){

        entities=new Entity[100];

    }
    private class Entity {
    
        String key;
        String value;
        public Entity(String key,String value){
            this.key=key;
            this.value=value;
        } 
    }
    
    public void put(String key, String value){
        int hash=Math.abs(key.hashCode()%entities.length);
        entities[hash]=new Entity(key, value);
    }
    public String get(String key){
        int hash=Math.abs(key.hashCode()%entities.length);
        if(entities[hash]!=null && entities[hash].key.equals(key)){
            return entities[hash].value;
        }
        return null;
    }
    public void remove(String key){
        int hash=Math.abs(key.hashCode()%entities.length);
        if(entities[hash]!=null && entities[hash].key.equals(key)){
            entities[hash]=null;
        }
    }
}

class Main {
    public static void main(String[] args) {
        //HashMap<String,Integer> maps=new HashMap<>();
        // map.put("Shashank", 89);
        // map.put("Rutuja", 99);
        // map.put("Rohit", 94);
        // System.out.println(map.get("Rutuja"));
        // System.out.println(map.getOrDefault("Apoorv", 78));
        // HashSet<Integer> set=new HashSet<>();
        // set.add(56);
        // set.add(25);
        // set.add(24);
        // set.add(12);
        // set.add(56);
        // System.out.println(set);
        MapusingHash  map=new MapusingHash();
        map.put("Mango","Aamba");
        map.put("Apple","safarchand");
        map.put("Banana","kel");
        System.out.println(map.get("Apple"));
    }
}
