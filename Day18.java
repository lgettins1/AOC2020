import java.io.BufferedReader;
import java.io.FileReader;

public class Day18 {
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
                        thisLine = thisLine.substring(0,b) + process(thisLine.substring(b + 1, cp)) + thisLine.substring(cp + 1);
                    }
                }
                 long a = process(thisLine);
                 System.out.println(" -> " + a);
                 total += a;
               }
            System.out.println("the total is " + total);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static long process(String tl){
        long r = 0;
        int pos = 0;
        int cp = 0;
        int en = 1;
        int fNum = 0;
        int op = 0;
        int nmbr;
        while(pos < tl.length()){
            if(tl.charAt(pos) == ' ' || pos == tl.length() - 1){
                if(en == 1){
                    en = 0;

                        if (pos < tl.length() - 1) {
                            nmbr = Integer.parseInt(tl.substring(cp, pos));
                        } else {
                            nmbr = Integer.parseInt(tl.substring(cp));
                        }

                    if (fNum == 0) {
                        fNum = 1;
                        r = nmbr;
                    } else {
                        switch (op) {
                            case 1 -> r += nmbr;
                            case 2 -> r = r * nmbr;
                        }
                    }
                } else {
                   en = 1;

                   while (tl.charAt(cp) == ' ' || tl.charAt(cp) == ')'){
                       pos ++;
                       cp ++;
                   }
                   if(tl.charAt(cp) == '+'){
                        op = 1;
                    } else {
                        op = 2;
                    }
                }
                cp = pos + 1;
            }
            pos ++;
        }
        return r;
    }
}
