import java.io.BufferedReader;
import java.io.FileReader;

public class Day8  {
        public static void main(String [] args) throws Exception {
            String thisLine;
            String [] oper = new String [700];
            int [] argu = new int [700];
            int [] hist = new int [700];
            int curpos = 0;
            int instr = 0;
            int accum = 0;
            hist[0] = 0;
            int stepcount = 0;

            try {
                BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day8input.txt"));
                while ((thisLine = br.readLine()) != null) {
                    oper[instr] = thisLine.substring(0 , 3);
                    argu[instr] = Integer.parseInt(thisLine.substring(4));
                    instr ++;
                }
                int repeat = 0;
                while(repeat == 0){
                    switch (oper[curpos]) {
                        case "nop" -> curpos++;
                        case "acc" -> {
                            accum += argu[curpos];
                            curpos++;
                        }
                        case "jmp" -> curpos += argu[curpos];
                    }

                    for(int ql = 0; ql <= stepcount; ql ++){
                        if (hist[ql] == curpos) {
                            repeat = 1;
                            break;
                        }
                    }
                    if(repeat == 0){
                        stepcount ++;
                        hist[stepcount] = curpos;
                    }
                    System.out.println(curpos + ",  " + accum);



                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


