import java.io.BufferedReader;
import java.io.FileReader;

public class Day16 {
    public static void main(String [] args) throws Exception {
        String thisLine;
        int section = 0;
        int minlo = 9990;
        int maxhi = 0;
        int errorRate = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day16input.txt"));
            while ((thisLine = br.readLine()) != null) {
                if(thisLine.length() == 0){
                    section ++;
                }
                switch(section){
                    case 0:
                        String[] aa = thisLine.split(":");
                        String[] a = aa[1].split(" ");
                        String[] b = a[1].split("-");
                        int b0 = Integer.parseInt(b[0]);
                        if(b0 < minlo){
                            minlo = b0;
                        }
                        String[] c = a[3].split("-");
                        int c0 = Integer.parseInt(c[1]);
                        if(c0 > maxhi){
                            maxhi = c0;
                        }
                         break;
                    case 1:
                        break;
                    case 2:
                        String[] c1 = thisLine.split(",");
                        if(c1.length < 3){
                            break;
                        }
                        for (String s : c1) {
                            int a2 = Integer.parseInt(s);
                            if (a2 < minlo || a2 > maxhi) {
                                errorRate += a2;
                                System.out.println(errorRate);
                            }

                        }

                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

