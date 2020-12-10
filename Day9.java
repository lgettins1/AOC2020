import java.io.BufferedReader;
import java.io.FileReader;

public class Day9 {
    public static void main(String [] args) throws Exception {
        String thisLine = null;
        long codes[] = new long[1001];
        int codenum = 0;
        int curpos = 25;
        long target = 0;


        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day9input.txt"));
            while ((thisLine = br.readLine()) != null) {
                codes[codenum] = Long.parseLong(thisLine);
                codenum++;
            }
            int found = 0;
            while (found == 0) {
                int ck = 0;
                for (int ol = curpos - 25; ol < curpos - 1; ol++) {
                    for (int il = ol + 1; il < curpos; il++) {
                        if (codes[il] + codes[ol] == codes[curpos]) {
                            ck = 1;
                        }
                    }
                }
                if(ck == 0){
                    found = 1;
                    System.out.println("*** The number " + codes[curpos] + " doesn't have two priors***");
                    target = codes[curpos];
                } else {
                    curpos ++;
                }
            }
            int fv = 0;
            int sv = 1;
            int found2 = 0;
            long temptotal;
            long mxv = 0;
            long mnv = 999999999;
            while(found2 == 0){
                temptotal = 0;
                for(int a = fv; a <= sv; a ++){
                    temptotal += codes[a];
                }
                if(temptotal == target){
                    for(int ql = fv; ql <= sv; ql ++){
                        if(codes[ql] < mnv){
                            mnv = codes[ql];
                        }
                        if(codes[ql] > mxv){
                            mxv = codes[ql];
                        }
                    }
                    System.out.println(mnv + " + " + mxv + " = " +(mnv + mxv));
                    found2 = 1;
                } else {
                    if( temptotal < target){
                        sv ++;
                        if(sv > 1000){
                            fv ++;
                            sv = fv + 1;
                        }
                    } else {
                        fv ++;
                        sv = fv + 1;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
