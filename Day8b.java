import java.io.BufferedReader;
import java.io.FileReader;

public class Day8b  {
        public static void main(String [] args) throws Exception {
            String thisLine = null;
            String [] oper = new String [700];
            String [] oper2 = new String [700];
            int [] argu = new int [700];
            int [] hist = new int [700];
            int curpos = 0;
            int instr = 0;
            int accum = 0;
            hist[0] = 0;

            try {
                BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day8input.txt"));
                while ((thisLine = br.readLine()) != null) {
                    oper[instr] = thisLine.substring(0 , 3);
                    argu[instr] = Integer.parseInt(thisLine.substring(4));
                    instr ++;
                }

                for(int loops = 0; loops < instr; loops ++){
                    int stepcount = 0;
                    accum = 0;
                    curpos = 0;

                    for(int a = 0; a < instr; a ++){
                        oper2[a] = oper[a];
                    }
                    if(oper[loops].equals("nop")){
                        oper2[loops] = "jmp";
                    }
                    if(oper[loops].equals("jmp")){
                        oper2[loops] = "nop";
                    }


                    int repeat = 0;
                    while(repeat == 0) {
                        switch (oper2[curpos]) {
                            case "nop":
                                curpos++;
                                break;
                            case "acc":
                                accum += argu[curpos];
                                curpos++;
                                break;
                            case "jmp":
                                curpos += argu[curpos];
                                break;
                        }

                        if(curpos >= instr){
                            System.out.println(accum + " is the answer!!!" );
                            repeat = 1;
                        }

                        for (int ql = 0; ql <= stepcount; ql++) {
                            if (hist[ql] == curpos) {
                                repeat = 1;
                            }
                        }
                        if (repeat == 0) {
                            stepcount++;
                            hist[stepcount] = curpos;
                        }


                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


