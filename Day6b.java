import java.io.BufferedReader;
import java.io.FileReader;

public class Day6b {
        public static void main(String [] args) throws Exception {
            String thisLine;
            int totalqs = 0;
            int qlist[] = new int [26];
            int mem = 0;
            for(int ql = 0; ql < 26; ql++){
                qlist[ql] = 0;
            }
            try {
                BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day6input.txt"));
                while ((thisLine = br.readLine()) != null) {
                    if(thisLine.length() > 0){
                        mem ++;
                        for(int ql = 0; ql < thisLine.length(); ql ++){
                            qlist[thisLine.charAt(ql) - 97] ++;
                        }
                    } else {
                        int qcount = 0;
                        for(int ql = 0; ql < 26; ql++){
                            if(qlist[ql] == mem){
                                qcount ++;
                            }
                        }
                        mem = 0;
                        for(int ql = 0; ql < 26; ql++){
                            qlist[ql] = 0;
                        }
                        totalqs += qcount;
                    }
                }
                System.out.println(totalqs + " is the sum of the counts....");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


