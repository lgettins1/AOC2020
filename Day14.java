import java.io.BufferedReader;
import java.io.FileReader;

public class Day14 {
    public static void main(String [] args) throws Exception {
        String thisLine;
        long [] mem = new long [99999];
        String mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        for(int a = 0 ;a < 99999; a++){
            mem[a] = 0;
        }
        String procBin;
        int memAdd;
        long memVal;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day14input.txt"));
            while ((thisLine = br.readLine()) != null) {
                if(thisLine.startsWith("mask")){
                    mask = thisLine.substring(7);
                } else {
                    String [] b = thisLine.split(" ");
                    memAdd = Integer.parseInt(b[0].substring(4,b[0].length() - 1));
                    procBin = Integer.toBinaryString(Integer.parseInt(b[2]));
                    procBin = "0".repeat(Math.max(0, (mask.length() - procBin.length()))) + procBin;
                    StringBuilder newBin = new StringBuilder();
                    for(int d = 0; d < (mask.length()); d ++ ){
                        switch (mask.charAt(d)) {
                            case 'X' -> newBin.append(procBin.charAt(d));
                            case '1' -> newBin.append("1");
                            case '0' -> newBin.append("0");
                        }
                    }
                    memVal = Long.parseLong(newBin.toString(),2);
                    mem[memAdd] = memVal;
                }
            }
            long sumOfAll = 0;
            for(int f = 0; f < 99999; f ++){
                sumOfAll += mem[f];
            }
            System.out.println("Sum of memory addresses is " + sumOfAll);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
