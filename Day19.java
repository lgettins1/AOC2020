import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Day19 {
    public static int ruleCount = 0;
    public static String[][] rules = new String [150][3];
    public static String[] messages = new String[450];
    public static String[] match = new String [500];
    public static int matchCount = 0;


    public static void main(String [] args) throws Exception {
        String thisLine;
        int section = 0;
        int msgCount = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day19inputb.txt"));
            while ((thisLine = br.readLine()) != null) {
                if(thisLine.length() == 0){
                    section = 1;
                }
                if(section == 0){
                    String[] a = thisLine.split(":");
                    rules[ruleCount][0] = a[0];
                    String[]b = a[1].split("\\|");
                    for(int c = 0; c < b.length; c ++){
                        rules[ruleCount][c + 1] = b[c].trim();
;                    }
                    ruleCount ++;
                } else {
                    messages[msgCount] = thisLine;
                    msgCount ++;
                }
            }
           String answer = "";
             find("0");
            System.out.println("-" + answer);
;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void find(String ruleNum) {
        String ans = null;
        for(int a = 0; a < ruleCount; a ++){
            if((rules[a][0].trim()).equals(ruleNum.trim())) {

                if (rules[a][1].charAt(0) == '"') {
                    match[matchCount] += rules[a][1].substring(1, 2);

                } else {
                    for (int spl = 1; spl < rules[a].length; spl++) {
                        if(rules[a].length == 2 && spl == 1){
                            match[matchCount + 1] = match[matchCount];
                        }
                        if(spl == 2){
                            matchCount ++;
                       }

                        String[] b = rules[a][spl].split(" ");
                        System.out.println(Arrays.deepToString(b));
                       for (int l = 0; l < b.length; l++) {
                            find(b[l]);
                        }
                        System.out.println("mc=" + matchCount + " " + match[matchCount]);
                    }
                }
            }
        }
    }
}
