import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Day16b{
        public static void main(String [] args) throws Exception {
            String thisLine;
            int section = 0;
            int[][] tixRules = new int [20][4];
            int[][] otherTix = new int [250][20];
            int[][] ruleMatrix = new int[20][20];
            int ruleCount = 0;
            int otherTixCount = 1;
            int minlo = 9990;
            int maxhi = 0;
            for(int f = 0; f < 20; f ++){
                for(int g = 0; g < 20; g ++){
                    ruleMatrix[f][g] = 0;
                }
            }
            try {
                BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day16input.txt"));
                while ((thisLine = br.readLine()) != null) {
                    if(thisLine.length() == 0){
                        section ++;
                    }
                    switch (section) {
                        case 0 -> {
                            String[] aa = thisLine.split(":");
                            String[] a = aa[1].split(" ");
                            String[] b = a[1].split("-");
                            int b0 = Integer.parseInt(b[0]);
                            if (b0 < minlo) {
                                minlo = b0;
                            }
                            String[] c = a[3].split("-");
                            int c0 = Integer.parseInt(c[1]);
                            if (c0 > maxhi) {
                                maxhi = c0;
                            }
                            tixRules[ruleCount][0] = b0;
                            tixRules[ruleCount][1] = Integer.parseInt(b[1]);
                            tixRules[ruleCount][2] = Integer.parseInt(c[0]);
                            tixRules[ruleCount][3] = c0;
                            ruleCount++;
                        }
                        case 1 -> {
                            String[] c2 = thisLine.split(",");
                            if (c2.length < 3) {
                                break;
                            }
                            for (int a1 = 0; a1 < c2.length; a1++) {
                                int a2 = Integer.parseInt(c2[a1]);
                                otherTix[0][a1] = a2;
                            }
                        }
                        case 2 -> {
                            String[] c1 = thisLine.split(",");
                            int badTicket = 0;
                            if (c1.length < 3) {
                                break;
                            }
                            for (int a1 = 0; a1 < c1.length; a1++) {
                                int a2 = Integer.parseInt(c1[a1]);
                                if (a2 < minlo || a2 > maxhi) {
                                    badTicket = 1;
                                }
                                otherTix[otherTixCount][a1] = a2;
                            }
                            if (badTicket == 0) {
                                otherTixCount++;
                            }
                        }
                    }
                }
                for(int rules = 0; rules < ruleCount; rules ++){
                    for(int pos = 0; pos < ruleCount; pos ++){
                        int good = 1;
                        for(int scn = 0; scn < otherTixCount; scn ++){
                            int ot = otherTix[scn][pos];
                            if ((ot < tixRules[rules][0]) || (ot > tixRules[rules][1] && ot < tixRules[rules][2])
                                    || (ot > tixRules[rules][3])) {
                                good = 0;
                                break;
                            }
                        }
                        if(good == 1){
                            ruleMatrix[rules][pos] = 1;
                        }
                    }
                }

                int [][]pattern = new int [20][2];
                int place = 0;
                for(int e = 0; e < 20; e++) {
                    int mt = 20;
                    for (int f = 0; f < 20; f++) {
                        int lntot = 0;
                        int loc = -1;
                        int unique1 =1;
                        for (int l = 0; l < place; l++) {
                            if (pattern[l][0] == f) {
                                unique1 = 0;
                                break;
                            }
                        }
                        if(unique1 == 1) {
                           for (int g = 0; g < 20; g++) {
                                int unique = 1;
                                for (int l = 0; l < place; l++) {
                                    if (pattern[l][1] == g) {
                                        unique = 0;
                                        break;
                                    }
                                }
                                if (unique == 1) {
                                    lntot += ruleMatrix[f][g];
                                    if(ruleMatrix[f][g] == 1) {
                                        loc = g;
                                    }
                                }
                            }
                            if (lntot > 0 && lntot < mt) {
                                mt = lntot;
                                pattern[place][0] = f;
                                pattern[place][1] = loc;
                            }
                        }
                    }
                    place++;
                }
                System.out.println(Arrays.deepToString(pattern));
                long g = 1;
                for(int ql = 0; ql < 6; ql++){
                    for(int ql1 = 0; ql1 < 20; ql1 ++) {
                        if(pattern[ql1][0] == ql) {
                            g = g * otherTix[0][pattern[ql1][1]];
                        }
                    }
                }
                System.out.println("The answer is " + g);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



