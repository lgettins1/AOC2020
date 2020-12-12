import java.io.BufferedReader;
import java.io.FileReader;

public class Day6 {
        public static void main(String [] args) throws Exception {
            String thisLine;
            StringBuilder thisGroup = new StringBuilder();
            int totalQs = 0;
            int[] qList = new int [26];
            try {
                BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day6input.txt"));
                while ((thisLine = br.readLine()) != null) {
                    if(thisLine.length() > 0){
                        thisGroup.append(thisLine);
                    } else {
                        int qCount = 0;
                        for(int ql = 0; ql < 26; ql++){
                            qList[ql] = 0;
                        }
                        for(int ql = 0; ql < thisGroup.length(); ql ++){
                            qList[thisGroup.charAt(ql) - 97] = 1;
                        }
                        for(int ql = 0; ql < 26; ql++){
                            qCount += qList[ql];
                        }
                        totalQs += qCount;

                        thisGroup = new StringBuilder();
                    }
                }
                System.out.println(totalQs + " is the sum of the counts.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




