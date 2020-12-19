import java.io.BufferedReader;
import java.io.FileReader;

public class Day17 {
    public static void main(String [] args) throws Exception {
        String thisLine;
        int d = 40;
        char[][][]curState = new char[d][d][d];
        char[][][]nextState = new char[d][d][d];
        for(int x = 0; x < d; x ++) {
            for (int y = 0; y < d; y++) {
                for (int z = 0; z < d; z++) {
                    curState[x][y][z] = '.';
                    nextState[x][y][z] = '.';
                }
            }
        }

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
                    curState[x + a][y][z] = thisLine.charAt(a);
                }
                y ++;
                ySize ++;
            }
            y = 15;
            for(int turn = 1; turn < 7; turn ++) {
                System.out.println("turn = " + turn);
                for (int c = z - turn; c <= z + turn; c++) {
                    System.out.println("z = " + c);
                    for (int b = y - turn; b < x + ySize + turn; b++) {
                        for (int a = x - turn; a < x + xSize + turn; a++) {
                            System.out.print(curState[a][b][c]);
                            int nCount = 0;
                            for(int cz = c - 1; cz <= c + 1; cz ++ ){
                                for(int cy = b - 1; cy <= b + 1; cy ++ ){
                                    for(int cx = a - 1; cx <= a + 1; cx ++ ){
                                        if(curState[cx][cy][cz] == '#'){
                                            nCount +=  1;
                                        }
                                    }
                                }
                            }
                            switch(curState[a][b][c]){
                                case '#':
                                     if(nCount == 4 || nCount == 3){
                                        nextState[a][b][c] = '#';
                                     } else {
                                        nextState[a][b][c] = '.';
                                     }
                                    break;
                                case '.':
                                    if(nCount == 3){
                                        nextState[a][b][c] = '#';
                                    } else {
                                        nextState[a][b][c] = '.';
                                    }
                                    break;
                            }
                        }
                        System.out.println();
                    }
                }
                active = 0;
                for (int c = z - turn; c <= z + turn; c++) {
                    for (int a = y - turn; a < y + ySize + turn; a++) {
                        for (int b = x - turn; b < x + xSize + turn; b++) {
                            if(nextState[a][b][c] == '#'){
                                active ++;
                            }
                            curState[a][b][c] = nextState[a][b][c];
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
