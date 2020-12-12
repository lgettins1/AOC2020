import java.io.BufferedReader;
import java.io.FileReader;

public class Day6b {
        public static void main(String [] args) throws Exception {
            String thisLine;
            int totalQs = 0;
            int[] qList = new int [26];
            int mem = 0;
            for(int ql = 0; ql < 26; ql++){
                qList[ql] = 0;
            }
            try {
                BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day6input.txt"));
                while ((thisLine = br.readLine()) != null) {
                    if(thisLine.length() > 0){
                        mem ++;
                        for(int ql = 0; ql < thisLine.length(); ql ++){
                            qList[thisLine.charAt(ql) - 97] ++;
                        }
                    } else {
                        int qCount = 0;
                        for(int ql = 0; ql < 26; ql++){
                            if(qList[ql] == mem){
                                qCount ++;
                            }
                        }
                        mem = 0;
                        for(int ql = 0; ql < 26; ql++){
                            qList[ql] = 0;
                        }
                        totalQs += qCount;
                    }
                }
                System.out.println(totalQs + " is the sum of the counts....");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


