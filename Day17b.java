import java.io.BufferedReader;
import java.io.FileReader;

public class Day17b {
        public static void main(String [] args) throws Exception {
            String thisLine;
            int dim = 40;
            char[][][][]curState = new char[dim][dim][dim][dim];
            char[][][][]nextState = new char[dim][dim][dim][dim];
            for(int w = 0; w < dim; w ++){
               for(int x = 0; x < dim; x ++) {
                    for (int y = 0; y < dim; y++) {
                        for (int z = 0; z < dim; z++) {
                            curState[w][x][y][z] = '.';
                            nextState[w][x][y][z] = '.';
                        }
                    }
                }
            }

            int w = 15;
            int x = 15;
            int y = 15;
            int z = 15;
            int xSize = 0;
            int ySize = 0;
            int active = 0;

            try {
                BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day17input.txt"));
                while ((thisLine = br.readLine()) != null) {
                    xSize = thisLine.length();
                    for(int a = 0; a < xSize; a ++){
                        curState[w][x + a][y][z] = thisLine.charAt(a);
                    }
                    y ++;
                    ySize ++;
                }
                y = 15;
                for(int turn = 1; turn < 7; turn ++) {
                    System.out.println("turn = " + (turn - 1));
                    for (int d = w - turn; d <= w + turn; d++) {
                        for (int c = z - turn; c <= z + turn; c++) {
                            System.out.println("z = " + (c - z) + " w = " + (d - w));
                            for (int b = y - turn; b < y + ySize + turn; b++) {
                                for (int a = x - turn; a < x + xSize + turn; a++) {
                                    System.out.print(curState[d][a][b][c]);
                                    int nCount = 0;
                                    for (int cw = d - 1; cw <= d + 1; cw++) {
                                        for (int cz = c - 1; cz <= c + 1; cz++) {
                                            for (int cy = b - 1; cy <= b + 1; cy++) {
                                                for (int cx = a - 1; cx <= a + 1; cx++) {
                                                    if (curState[cw][cx][cy][cz] == '#') {
                                                        nCount += 1;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    switch (curState[d][a][b][c]) {
                                        case '#':
                                            if (nCount == 4 || nCount == 3) {
                                                nextState[d][a][b][c] = '#';
                                            } else {
                                                nextState[d][a][b][c] = '.';
                                            }
                                            break;
                                        case '.':
                                            if (nCount == 3) {
                                                nextState[d][a][b][c] = '#';
                                            } else {
                                                nextState[d][a][b][c] = '.';
                                            }
                                            break;
                                    }
                                }
                                System.out.println();
                            }
                        }
                    }
                        active = 0;
                        for(int d1 = w - turn; d1 <= w + turn; d1 ++) {
                            for (int c = z - turn; c <= z + turn; c++) {
                                for (int a = y - turn; a < y + ySize + turn; a++) {
                                    for (int b = x - turn; b < x + xSize + turn; b++) {
                                        if (nextState[d1][a][b][c] == '#') {
                                            active++;
                                        }
                                        curState[d1][a][b][c] = nextState[d1][a][b][c];
                                    }
                                }
                            }
                        }

                }
                System.out.println(active + " active cubes.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


