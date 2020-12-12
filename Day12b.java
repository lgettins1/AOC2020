import java.io.BufferedReader;
import java.io.FileReader;

public class Day12b {
        public static void main(String [] args) throws Exception {
            String thisLine;
            int del;
            int x = 0;
            int y = 0;
            int wpx = 10;
            int wpy = -1;
            int amt;
            int t;

            try {
                BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day12input.txt"));
                while ((thisLine = br.readLine()) != null) {
                    amt = Integer.parseInt(thisLine.substring(1));
                    System.out.println(x + "," + y);
                    System.out. println(wpx + " "+ wpy + " " + thisLine);
                    switch (thisLine.charAt(0)) {
                        case 'N' -> wpy -= amt;
                        case 'E' -> wpx += amt;
                        case 'S' -> wpy += amt;
                        case 'W' -> wpx -= amt;
                        case 'F' -> {
                            x += wpx * amt;
                            y += wpy * amt;
                        }
                        case 'R' -> {
                            del =(amt / 90);
                            switch (del) {
                                case 1 -> {
                                    t = wpx;
                                    wpx = -wpy;
                                    wpy = t;
                                }
                                case 2 -> {
                                    wpy = -wpy;
                                    wpx = -wpx;
                                }
                                case 3 -> {
                                    t = -wpx;
                                    wpx = wpy;
                                    wpy = t;
                                }
                            }
                        }
                        case 'L' -> {
                            del =(amt / 90);
                            switch (del) {
                                case 1 -> {
                                    t = -wpx;
                                    wpx = wpy;
                                    wpy = t;
                                }
                                case 2 -> {
                                    wpy = -wpy;
                                    wpx = -wpx;
                                }
                                case 3 -> {
                                    t = wpx;
                                    wpx = -wpy;
                                    wpy = t;
                                }
                            }
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
