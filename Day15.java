public class Day15 {
    public static void main(String [] args) throws Exception {
        int[] numList = new int [30000001];
        int[] input = {14,8,16,0,1,17};
        int pos = 0;
        int lastSeen;
        while(pos < input.length){
            numList[pos + 1] = input [pos];
            pos ++;
        }
        while(pos < 30000000){
            pos ++;
            lastSeen = -1;
            for(int a = pos - 2; a > 0; a --){
                if(numList[pos - 1] == numList [a]){
                    lastSeen = a;
                    break;
                }
            }
            if(lastSeen == -1){
                numList[pos] = 0;
            } else {
                numList[pos] = (pos - lastSeen - 1);
            }
             System.out.println(pos + " " + numList[pos]);
        }


    }
}
