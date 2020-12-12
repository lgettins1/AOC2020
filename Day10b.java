import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Day10b {
    public static int [] adapters = new int[102];
    public static int lineNum = 1;
    public static int maxVal = 0;
    public static long combos = 0;


    public static void main(String[] args) throws Exception {
        String thisLine ;
        adapters[0] = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day10input.txt"));
            while ((thisLine = br.readLine()) != null) {
                int pv = Integer.parseInt(thisLine);
                if (pv > maxVal) {
                    maxVal = pv;
                }
                adapters[lineNum] = pv;

                lineNum++;
            }
            maxVal += 3;
            adapters[lineNum] = maxVal;

            Arrays.sort(adapters);
            System.out.printf("Modified  : %s",
                    Arrays.toString(adapters));
            System.out.println();
            findNext(0, 0);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findNext(int jolt, int curPos) {
        if (adapters[curPos] == maxVal) {
            combos++;
            System.out.println(combos);
        }
        if (curPos < lineNum) {
            if (adapters[curPos + 1] == jolt + 1) {
                findNext(jolt + 1, curPos + 1);
            }
            if (adapters[curPos + 1] == jolt + 2) {
                findNext(jolt + 2, curPos + 1);
            }
            if (adapters[curPos + 1] == jolt + 3) {
                findNext(jolt + 3, curPos + 1);
            }
            if (curPos < lineNum - 1) {
                if (adapters[curPos + 2] == jolt + 2) {
                findNext(jolt + 2, curPos + 2);
            }
            if (adapters[curPos + 2] == jolt + 3) {
                findNext(jolt + 3, curPos + 2);
            }
                if (curPos < lineNum - 2) {
                    if (adapters[curPos + 3] == jolt + 3) {
                findNext(jolt + 3, curPos + 3);
            }
        }
    }
}
}
}
