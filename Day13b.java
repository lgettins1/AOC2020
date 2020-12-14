import java.io.BufferedReader;
import java.io.FileReader;

public class Day13b {
    public static void main(String [] args) throws Exception {

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day13input.txt"));
            br.readLine();
            String t = br.readLine();
            String[] a = t.split(",");
            int [][] buses = new int [15][3];
            int busCount = 0;
            for (int q = 0; q < a.length; q ++) {
                if (a[q].charAt(0) != 'x') {
                    buses[busCount][0] = Integer.parseInt(a[q]);
                    buses[busCount][1] = q;
                    buses[busCount][2] = 0;
                    busCount ++;
                }
            }
            long ckTime = 755;
            long mp = 1;
               while(true){
               int match = 0;
                for(int b = 0; b < busCount; b ++){
                   long offset;
                    if(ckTime % buses[b][0] == 0) {
                        offset = 0;
                    }else{
                        offset = buses[b][0]  - ckTime % buses[b][0];
                    }
                    if((offset - buses[b][1])%buses[b][0] == 0){
                        match ++;
                        if(buses[b][2] == 0) {
                            mp = mp * buses[b][0];
                            buses[b][2] =  1;
                        }
                    }
                }
                if(match == busCount){
                   break;
                }
                ckTime += mp;
            }
            System.out.println("The answer is: " + ckTime);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
