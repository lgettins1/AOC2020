import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Math;


public class Day12 {
        public static void main(String [] args) throws Exception {
            String thisLine;
            int dir = 1;
            int x = 0;
            int y = 0;
            int amt;

            try {
                BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day12input.txt"));
                while ((thisLine = br.readLine()) != null) {
                    amt = Integer.parseInt(thisLine.substring(1));
                    switch (thisLine.charAt(0)) {
                        case 'N' -> y -= amt;
                        case 'E' -> x += amt;
                        case 'S' -> y += amt;
                        case 'W' -> x -= amt;
                        case 'F' -> {
                            x += ((2 - dir) % 2) * amt;
                            y += ((dir - 1) % 2) * amt;
                        }
                        case 'R' -> {
                            dir += (amt / 90);
                            dir = dir % 4;
                        }
                        case 'L' -> {
                            dir -= (amt / 90);
                            dir += 4;
                            dir = dir % 4;
                        }
                    }
                }
                System.out.println("The coordinates are " + x + " & " + y);
                System.out.println("The answer is " + (Math.abs(x) + Math.abs(y)));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


}
