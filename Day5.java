import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Math;
import java.util.Arrays;

public class Day5 {
    public static void main(String [] args) throws Exception {
        String thisLine;
        int minr;
        int minc;
        int maxp = 0;
        int[] seats = new int[1000];
        int seatn = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day5input.txt"));
            while ((thisLine = br.readLine()) != null) {
                minr = 0;
                minc = 0;
                for(int a = 0; a < 7; a++) {
                    if (thisLine.charAt(a) == 'B') {
                        minr += Math.pow(2, (6 - a));
                    }
                }
                for(int a = 0; a < 3; a++){
                    if(thisLine.charAt(a + 7) == 'R'){
                        minc += Math.pow(2,(2 - a));
                    }
                }
                int seatval = (minr * 8) + minc;
                if(seatval > maxp) {
                    maxp = seatval;
                }
                seats[seatn] = seatval;
                seatn ++;
            }
            System.out.println(maxp + " is the highest seat ID");
            Arrays.sort(seats);
            for(int ql = 1; ql < seats.length; ql ++){
                if(seats[ql] - seats[ql - 1] == 2){
                    System.out.println("my seat is between " + seats[ql - 1] + " and " + seats[ql]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

