import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Day10b {
    public static int adapters[] = new int[102];
    public static int linenum = 1;
    public static int maxval = 0;
    public static long combos = 0;

    public static void main(String[] args) throws Exception {
        String thisLine = null;
        adapters[0] = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day10input.txt"));
            while ((thisLine = br.readLine()) != null) {
                int pv = Integer.parseInt(thisLine);
                if (pv > maxval) {
                    maxval = pv;
                }
                adapters[linenum] = pv;

                linenum++;
            }
            maxval += 3;
            adapters[linenum] = maxval;

            Arrays.sort(adapters);
            System.out.printf("Modified  : %s",
                    Arrays.toString(adapters));
            System.out.println();
            findnext(0, 0);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findnext(int jolt, int curpos) {
        if (adapters[curpos] == maxval) {
            combos++;
            System.out.println(combos);
        }
        if (curpos < linenum) {
            if (adapters[curpos + 1] == jolt + 1) {
                findnext(jolt + 1, curpos + 1);
            }
            if (adapters[curpos + 1] == jolt + 2) {
                findnext(jolt + 2, curpos + 1);
            }
            if (adapters[curpos + 1] == jolt + 3) {
                findnext(jolt + 3, curpos + 1);
            }
            if (curpos < linenum - 1) {
                if (adapters[curpos + 2] == jolt + 2) {
                findnext(jolt + 2, curpos + 2);
            }
            if (adapters[curpos + 2] == jolt + 3) {
                findnext(jolt + 3, curpos + 2);
            }
                if (curpos < linenum - 2) {
                    if (adapters[curpos + 3] == jolt + 3) {
                findnext(jolt + 3, curpos + 3);
            }
        }
    }
}
}
}
