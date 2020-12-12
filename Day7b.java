import java.io.BufferedReader;
import java.io.FileReader;

public class Day7b {
        public static int [][] bagCount = new int [600][8];
        public static String [][] bagDesc = new String [600][10];
        public static int ruleCount;
        public static int globalBagCount;

        public static void main(String [] args) throws Exception {
            String thisLine;
            String [] scanline;
            ruleCount = 0;
            String [] pb2 ;



            try {
                BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day7input.txt"));
                while ((thisLine = br.readLine()) != null) {
                    scanline = thisLine.split(",");
                    int l = scanline.length;
                    String[] pb = scanline[0].split(" ");
                    bagDesc[ruleCount][0] = pb[0] + " " + pb[1];
                    bagCount[ruleCount][0] = l;
                    if (scanline[0].endsWith("no other bags.")) {
                        bagCount[ruleCount][0] = 0;
                    } else {
                        bagDesc[ruleCount][1] = pb[5] + " " + pb[6];
                        bagCount[ruleCount][1] = Integer.parseInt(pb[4]);
                        if (l > 1) {
                            for (int ql = 2; ql <= l; ql++) {
                                pb2 = scanline[ql - 1].split(" ");
                                bagDesc[ruleCount][ql] = pb2[2] + " " + pb2[3];
                                bagCount[ruleCount][ql] = Integer.parseInt(pb2[1]);
                            }
                        }
                    }
                    ruleCount ++;
                }
                globalBagCount = -1;
                returnBag("shiny gold");
                System.out.println(globalBagCount + " bags");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void returnBag(String bag) {
            for(int ql = 0; ql < ruleCount; ql ++){
                if(bagDesc[ql][0].equals(bag)){
                    globalBagCount++;
                    if(bagCount[ql][0] != 0) {
                        for(int ql2 = 1; ql2 <= bagCount[ql][0]; ql2++){
                            for(int ql3 = 1; ql3 <= bagCount[ql][ql2];ql3 ++){
                                returnBag(bagDesc[ql][ql2]);
                            }
                        }
                    }
                }
            }
        }
}
