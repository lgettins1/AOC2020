import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Day10c {
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
            int prgps = 0;
            int onList = 0;
            int[][] rList = new int [2][30];
            for(int ql = 1; ql <= lineNum; ql ++){
                if(adapters[ql] - adapters[ql - 1] == 1){
                    onList ++;
                } else {
                    if(onList >= 2){

                        rList[0][prgps] = onList;
                        switch (onList) {
                            case 2 -> rList[1][prgps] = 2;
                            case 3 -> rList[1][prgps] = 4;
                            case 4 -> rList[1][prgps] = 7;
                        }
                        prgps ++;
                    }
                    onList = 0;
                }
            }
            long prd = 1;
            for(int ql = 0; ql < prgps; ql ++){
                System.out.println(rList[0][ql] + " , " + rList[1][ql]);
                prd = prd * rList[1][ql];
            }
            System.out.println("The answer is " + prd);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
