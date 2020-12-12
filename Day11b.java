import java.io.BufferedReader;
import java.io.FileReader;

public class Day11b {
        public static void main(String [] args) throws Exception {
            String thisLine;
            String [] curSeats = new String [100];
            String [] newSeats = new String [100];
            StringBuilder newRow;
            int rowCount = 0;
            int rowLen;
            int nxc;
            int nxr;
            int ocSeats = 0;
            int[][] vector = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};


            try {
                BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day11input.txt"));
                while ((thisLine = br.readLine()) != null) {
                    curSeats[rowCount] = thisLine;
                    rowCount++;
                }
                rowLen = curSeats[0].length();
                int repeating = 0;

                while(repeating == 0) {

                    for (int sr = 0; sr < rowCount; sr++) {
                        newRow = new StringBuilder();
                        for (int sc = 0; sc < rowLen; sc++) {
                            int oc = 0;

                            for(int chk = 0; chk < 8; chk++) {
                                int fnd = 0;
                                nxc = sc;
                                nxr = sr;
                                while (fnd == 0) {
                                    nxc += vector[chk][0];
                                    nxr += vector[chk][1];
                                    if (nxc < 0 || nxc == rowLen || nxr < 0 || nxr == rowCount) {
                                        fnd = 1;

                                    } else {

                                        if (curSeats[nxr].charAt(nxc) =='L') {
                                        fnd = 1;
                                    }
                                    if (curSeats[nxr].charAt(nxc) == '#') {
                                        fnd = 1;
                                        oc++;
                                    }
                                    }
                                }
                            }
                               switch (curSeats[sr].substring(sc, sc + 1)) {
                                   case ".":
                                        newRow.append(".");
                                        break;
                                   case "L":
                                        if (oc == 0) {
                                            newRow.append("#");
                                        } else {
                                            newRow.append("L");
                                        }
                                        break;
                                   case "#":
                                        if (oc > 4) {
                                            newRow.append("L");
                                        } else {
                                            newRow.append("#");
                                        }
                                        break;
                               }
                            }
                            newSeats[sr] = newRow.toString();
                        }

                        int cc = 0;
                        ocSeats = 0;
                        for (int ql3 = 0; ql3 < rowCount; ql3++) {
                            if (curSeats[ql3].equals(newSeats[ql3])) {
                                cc++;
                                for(int ql4 = 0; ql4 < rowLen; ql4++){
                                    if(curSeats[ql3].charAt(ql4) == '#'){
                                        ocSeats ++;
                                    }
                                }
                            }
                            curSeats[ql3] = newSeats[ql3];
                        }
                        if(cc == rowCount){
                            repeating = 1;
                        }
                                        }
                System.out.println("The answer is " + ocSeats);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


