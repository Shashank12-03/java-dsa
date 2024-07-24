package string;

public class timing {
    public static void main(String[] args) {
        System.out.println(timeDifference("12:45:am","02:20:pm"));
    }

    private static String timeDifference(String time1, String time2) {
        int time1Hr = 0;
        int time1Min = 0; 
        int time2Hr = 0;
        int time2Min = 0; 
        if(time1.contains("am")){
            System.out.println(time1.substring(0, 2));
            if (!time1.substring(0, 2).equals("12")){
                time1Hr = Integer.parseInt(time1.substring(0, 2));
            }
        }else if(time1.contains("pm")){
            if (!time1.substring(0, 2).equals("12")){
                time1Hr = Integer.parseInt(time1.substring(0, 2))+12;
            }else{
                time2Hr = 12;
            }
        }
        time1Min = Integer.parseInt(time1.substring(3, 5));

        if(time2.contains("am")){
            if (!time1.substring(0, 2).equals("12")){
                time2Hr = Integer.parseInt(time1.substring(0, 2));     
            }
        }else if(time2.contains("pm")){
            System.out.println(time2.substring(0, 2));
            if (!time2.substring(0, 2).equals("12")){
                time2Hr = Integer.parseInt(time2.substring(0, 2))+12;
            }else{
                time2Hr = 12;
            }
        }
        time2Min = Integer.parseInt(time2.substring(3, 5));
        int min = Math.abs(time2Min-time1Min);
        int hr = Math.abs(time1Hr-time2Hr);
        return String.valueOf(hr)+ ":" + String.valueOf(min);
    }
}
