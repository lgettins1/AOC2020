import java.io.BufferedReader;
import java.io.FileReader;

public class Day18b {
    public static void main(String [] args) throws Exception {
        String thisLine;
        long total = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day18input.txt"));
            while ((thisLine = br.readLine()) != null) {
                thisLine = thisLine.trim();
                for(int b = thisLine.length() - 1; b >=0; b--){
                    if(thisLine.charAt(b) == '('){
                        int cp = b;
                        while(thisLine.charAt(cp) != ')'){
                            cp ++;
                        }
                        thisLine = thisLine.substring(0 , b) + process(thisLine.substring(b + 1, cp)) + thisLine.substring(cp + 1);
                   }
                }
                long a = process(thisLine);
                System.out.println(a);

                total += a;
            }
            System.out.println("the total is " + total);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static long process(String tl){
        long r;
        long nmbr;
        String[] prs = tl.split(" ");
        int oo = 1;
        while(oo < prs.length){
            if(prs[oo].charAt(0) == '+'){
                nmbr = Long.parseLong(prs[oo - 1]) + Long.parseLong(prs[oo + 1]);
                StringBuilder a = new StringBuilder();
                for(int o1 = 0; o1 < oo - 1; o1 ++){
                    a.append(prs[o1]).append(" ");
                }

                StringBuilder b = new StringBuilder();
                for(int o2 = oo + 2; o2 < prs.length; o2 ++){
                    b.append(prs[o2]).append(" ");
                }
                a.append(nmbr).append(" ").append(b);
                prs = a.toString().split(" ");
            } else {
                oo += 2;
            }
        }
        oo = 1;
        while(oo < prs.length) {
            if (prs[oo].charAt(0) == '*') {
                nmbr =  Long.parseLong(prs[oo - 1]) * Long.parseLong(prs[oo + 1]);
                StringBuilder a = new StringBuilder();
                for (int o1 = 0; o1 < oo - 1; o1++) {
                    a.append(prs[o1]).append(" ");
                }

                StringBuilder b = new StringBuilder();
                for (int o2 = oo + 2; o2 < prs.length; o2++) {
                    b.append(prs[o2]).append(" ");
                }
                a.append(nmbr).append(" ").append(b);
               prs = a.toString().split(" ");
            } else {
                oo += 2;
            }
        }
        r = Long.parseLong(prs[0]);

        return r;
    }
}
