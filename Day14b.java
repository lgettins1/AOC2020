import java.io.BufferedReader;
import java.io.FileReader;

public class Day14b {
    public static void main(String [] args) throws Exception {
        String thisLine;
        long [][] mem = new long [99999][2];
        String mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        for(int a = 0 ;a < 99999; a++){
            mem[a][1] = 0;
        }
        String procBin;
        long memAdd;
        long memVal;
        int addrCount = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day14input.txt"));
            while ((thisLine = br.readLine()) != null) {
                if (thisLine.startsWith("mask")) {
                    mask = thisLine.substring(7);
                } else {
                    String[] b = thisLine.split(" ");
                    procBin = Integer.toBinaryString(Integer.parseInt(b[0].substring(4, b[0].length() - 1)));
                    memVal = Integer.parseInt(b[2]);
                    procBin = "0".repeat(Math.max(0, (mask.length() - procBin.length()))) + procBin;
                    StringBuilder newBin = new StringBuilder();
                    int xCount = 0;
                    for (int d = 0; d < (mask.length()); d++) {
                        switch (mask.charAt(d)) {
                            case 'X' -> {
                                newBin.append("X");
                                xCount++;
                            }
                            case '1' -> newBin.append("1");
                            case '0' -> newBin.append(procBin.charAt(d));
                        }
                    }

                    String fltString;
                    for (int ql = 0; ql < Math.pow(2, xCount); ql++) {
                        StringBuilder newAddr = new StringBuilder();
                        fltString = Integer.toBinaryString(ql);
                        fltString = "0".repeat(Math.max(0, (xCount - fltString.length()))) + fltString;
                        int fndX = 0;
                        for (int ql2 = 0; ql2 < newBin.length(); ql2 ++) {

                            switch (newBin.charAt(ql2)) {
                                case '0' -> newAddr.append("0");
                                case '1' -> newAddr.append('1');
                                case 'X' -> {
                                    newAddr.append(fltString.charAt(fndX));
                                    fndX++;
                                }
                            }
                        }
                        memAdd = Long.parseLong(newAddr.toString(),2);
                        if(addrCount == 0){
                            mem[addrCount][0] =memAdd;
                            mem[addrCount][1] = memVal;
                            addrCount ++;
                        } else {
                            int fndAd = 0;
                            for(int ql3 = 0; ql3 < addrCount; ql3 ++){
                                if(mem[ql3][0] == memAdd){
                                    mem[ql3][1] = memVal;
                                    fndAd = 1;
                                }
                            }
                            if(fndAd == 0){
                                mem[addrCount][0] = memAdd;
                                mem[addrCount][1] = memVal;
                                addrCount ++;
                            }
                        }

                    }
                }
            }
            long sumOfAll = 0;
            for (int f = 0; f < 99999; f++) {
                sumOfAll += mem[f][1];
            }
            System.out.println("Sum of memory addresses is " + sumOfAll);

        }
        catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

