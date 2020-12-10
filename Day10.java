import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Day10 {
    public static void main(String [] args) throws Exception {
        String thisLine = null;
        int adapters[] = new int [102];
        int linenum = 1;
        adapters[0] = 0;
        int maxval = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day10input.txt"));
            while ((thisLine = br.readLine()) != null) {
                int pv = Integer.parseInt(thisLine);
                if(pv > maxval){
                    maxval = pv;
                }
                adapters[linenum] = pv;

                linenum++;
            }

            System.out.printf("Original  : %s",
                    Arrays.toString(adapters));
            System.out.println();
            adapters[linenum ] = maxval + 3;

            Arrays.sort(adapters);
             System.out.printf("Modified  : %s",
                    Arrays.toString(adapters));
            System.out.println();

            int oj = 0;
            int tj = 0;
            for(int ql = 1; ql <= linenum; ql ++){
             //   System.out.println(adapters[ql]);
                if(adapters[ql] - adapters[ql - 1] == 1){
                    oj ++;
                }
                if(adapters[ql] - adapters[ql - 1] == 3){
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
