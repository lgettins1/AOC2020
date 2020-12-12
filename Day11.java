import java.io.BufferedReader;
import java.io.FileReader;

public class Day11 {
    public static void main(String [] args) throws Exception {
        String thisLine;
        String [] curSeats = new String [100];
        String [] newSeats = new String [100];
        StringBuilder newRow;
        int rowCount = 0;
        int rowLen;
        int mnc;
        int mxc;
        int mnr;
        int mxr;
        int ocSeats = 0;


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
                        mnc = sc - 1;
                        if (mnc < 0) {
                            mnc = 0;
                        }
                        mnr = sr - 1;
                        if (mnr < 0) {
                            mnr = 0;
                        }
                        mxc = sc + 1;
                        if (mxc == rowLen) {
                            mxc = rowLen - 1;
                        }
                        mxr = sr + 1;
                        if (mxr == rowCount) {
                            mxr = rowCount - 1;
                        }
                        int oc = 0;
                        String spt;
                        for (int ql1 = mnr; ql1 <= mxr; ql1++) {
                            for (int ql2 = mnc; ql2 <= mxc; ql2++) {
                                spt = curSeats[ql1].substring(ql2, ql2 + 1);
                                if (spt.equals("#")) {
                                    oc++;
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
                System.out.println();
            }
            System.out.println("The answer is " + ocSeats);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
