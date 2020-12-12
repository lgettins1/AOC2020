import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Day10 {
    public static void main(String [] args) throws Exception {
        String thisLine;
        int[] adapters = new int [102];
        int lineNum = 1;
        adapters[0] = 0;
        int maxVal = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day10input.txt"));
            while ((thisLine = br.readLine()) != null) {
                int pv = Integer.parseInt(thisLine);
                if(pv > maxVal){
                    maxVal = pv;
                }
                adapters[lineNum] = pv;

                lineNum++;
            }

            adapters[lineNum ] = maxVal + 3;
            Arrays.sort(adapters);
             System.out.printf("Modified  : %s",
                    Arrays.toString(adapters));
            System.out.println();

            int oj = 0;
            int tj = 0;
            for(int ql = 1; ql <= lineNum; ql ++){
                int i = adapters[ql] - adapters[ql - 1];
                if(i == 1){
                    oj ++;
                }
                if(i == 3){
                    tj ++;
                }
            }
            System.out.println("we have " + oj + " one jolt differences and " + tj + " three jolt differences");
            System.out.println("the product is " + (oj * tj));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
