import java.io.BufferedReader;
import java.io.FileReader;

public class Day13 {
    public static void main(String [] args) throws Exception {
        int firstTime;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day13input.txt"));
            firstTime = Integer.parseInt(br.readLine());
            String t = br.readLine();
            String[] a = t.split(",");
            int [] buses = new int [15];
            int busCount = 0;
            for (String s : a) {
                if (s.charAt(0) != 'x') {
                    buses[busCount] = Integer.parseInt(s);
                    busCount ++;
                }
            }
            int soonBus = 0;
            int soonTime = 100;
            for(int q2 = 0; q2 < busCount; q2 ++){
                int b = buses[q2] - (firstTime % buses[q2]);
                if(b < soonTime){
                    System.out.println(firstTime + ", bus " + buses [q2] + " at " + b);
                    soonBus = buses[q2];
                    soonTime = b;
                }
            }
            System.out.println("winner bus " + soonBus + " at " + soonTime + " = " + (soonBus * soonTime));




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
