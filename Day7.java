import java.io.BufferedReader;
import java.io.FileReader;

public class Day7 {
        public static void main(String [] args) throws Exception {
            String thisLine;
            String [] scanline;
            String [] target = new String [10000];
            target[0] = "shiny gold";
            int answers = 0;
            int [][] bagCount = new int [600][8];
            String [][] bagDesc = new String [600][10];
            int ruleCount = 0;
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
                int oldAnswer = answers;
                int bd = 1;
                while(bd == 1){

                    for(int ql = 0; ql < ruleCount; ql++){
                        if(bagCount[ql][0] > 0) {
                            for (int ck = 1; ck <= bagCount[ql][0]; ck++) {
                                for (int lck = 0; lck <= answers; lck++) {
                                    if (bagDesc[ql][ck].equals(target[lck])) {
                                        int unique = 1;
                                        for(int ce = 0; ce <= answers; ce ++){
                                            if(target[ce].equals(bagDesc[ql][0])){
                                                unique = 0;
                                                break;
                                            }
                                        }
                                        if(unique == 1){
                                            answers++;
                                            target[answers] = bagDesc[ql][0];
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(answers == oldAnswer){
                        bd = 0;
                    } else {
                        oldAnswer = answers;
                    }
                }
                for(int a = 0; a <= answers; a ++){
                    System.out.println(target[a]);
                }
                System.out.println(answers +" bags");


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
