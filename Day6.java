import java.io.BufferedReader;
import java.io.FileReader;

public class Day6 {
        public static void main(String [] args) throws Exception {
            String thisLine;
            String thisGroup = "";
            int totalqs = 0;
            int qlist[] = new int [26];
            try {
                BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day6input.txt"));
                while ((thisLine = br.readLine()) != null) {
                    if(thisLine.length() > 0){
                        thisGroup += thisLine;
                    } else {
                        int qcount = 0;
                        for(int ql = 0; ql < 26; ql++){
                            qlist[ql] = 0;
                        }
                        for(int ql = 0; ql < thisGroup.length(); ql ++){
                            qlist[thisGroup.charAt(ql) - 97] = 1;
                        }
                        for(int ql = 0; ql < 26; ql++){
                            qcount += qlist[ql];
                        }
                        totalqs += qcount;

                        thisGroup = "";
                    }
                }
                System.out.println(totalqs + " is the sum of the counts.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




