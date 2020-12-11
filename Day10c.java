import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Day10c {
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

           adapters[linenum ] = maxval + 3;

            Arrays.sort(adapters);
            System.out.printf("Modified  : %s",
                    Arrays.toString(adapters));
            System.out.println();
            int prgps = 0;
            int onelist = 0;
            int rlist [][] = new int [2][30];
            for(int ql = 1; ql <= linenum; ql ++){
                if(adapters[ql] - adapters[ql - 1] == 1){
                    onelist ++;
                } else {
                    if(onelist >= 2){

                        rlist[0][prgps] = onelist;
                        switch(onelist){
                            case 2:
                                rlist[1][prgps] = 2;
                                break;
                            case 3:
                                rlist[1][prgps] = 4;
                                break;
                            case 4:
                                rlist[1][prgps] = 7;
                                break;
                        }
                        prgps ++;
                    }
                    onelist = 0;
                }
            }
            long prd = 1;
            for(int ql = 0; ql < prgps; ql ++){
                System.out.println(rlist[0][ql] + " , " + rlist[1][ql]);
                prd = prd * rlist[1][ql];
            }
            System.out.println("The answer is " + prd);




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
