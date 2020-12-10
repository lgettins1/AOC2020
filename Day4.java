import java.io.BufferedReader;
import java.io.FileReader;

public class Day4 {
        public static void main(String [] args) throws Exception {
            String thisLine = null;
            String thisDoc = "";
            String lbl;
            String value;
            int valid = 0;
            int fc;
            String doc [];
            String eyes[] = new String[7];
            eyes[0] = "amb";
            eyes[1] = "blu";
            eyes[2] = "brn";
            eyes[3] = "gry";
            eyes[4] = "grn";
            eyes[5] = "hzl";
            eyes[6] = "oth";


            try {
                BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/aoc20day4input.txt"));
                while ((thisLine = br.readLine()) != null) {
                    if (thisLine.length() > 0) {
                        thisDoc += thisLine + " ";
                    } else {
                        // parse document and reset thisDoc
                        fc = 0;
                        doc = thisDoc.split(" ");


                        for(int a = 0; a < doc.length; a++) {

                            lbl = doc[a].substring(0 , 3);
                            value = doc[a].substring(4);

                            switch(lbl){
                                case "byr":
                                    if(value.length() == 4){
                                        int yc = 0;
                                        for(int ql = 0; ql < 4; ql ++){
                                            if(value.charAt(ql) > 47 && value.charAt(ql) < 58){
                                                yc ++;
                                            }
                                            if(yc ==4){
                                                int ty = Integer.parseInt(value);
                                                if(ty >= 1920 && ty <= 2002){
                                                    fc ++;
                                                }
                                            }
                                        }
                                    }

                                    break;
                                case "iyr":
                                    if(value.length() == 4){
                                        int yc = 0;
                                        for(int ql = 0; ql < 4; ql ++) {
                                            if (value.charAt(ql) > 47 && value.charAt(ql) < 58) {
                                                yc++;
                                            }
                                        }
                                        if(yc ==4){
                                            int ty = Integer.parseInt(value);
                                            if(ty >= 2010 && ty <= 2020){
                                                fc ++;
                                            }
                                        }
                                    }
                                    break;
                                case "eyr":
                                    if(value.length() == 4){
                                        int yc = 0;
                                        for(int ql = 0; ql < 4; ql ++) {
                                            if (value.charAt(ql) > 47 && value.charAt(ql) < 58) {
                                                yc++;
                                            }
                                        }
                                        if(yc ==4){
                                            int ty = Integer.parseInt(value);
                                            if(ty >= 2020 && ty <= 2030){
                                                fc ++;
                                            }
                                        }

                                    }
                                    break;
                                case "hgt":
                                    if(value.length() == 4){
                                        if(value.substring(2).equals("in")){
                                            int yc = 0;
                                            for(int ql = 0; ql < 2; ql ++) {
                                                if (value.charAt(ql) > 47 && value.charAt(ql) < 58) {
                                                    yc++;
                                                }
                                            }
                                            if(yc == 2){
                                                int ty = Integer.parseInt(value.substring(0 , 2));
                                                if(ty >= 59 && ty <= 76){
                                                    fc ++;
                                                }
                                            }
                                        }
                                    } else {
                                        if(value.length() == 5){
                                            if(value.substring(3).equals("cm")){
                                                int yc = 0;
                                                for(int ql = 0; ql < 3; ql ++){
                                                    if(value.charAt(ql) > 47 && value.charAt(ql) < 58){
                                                        yc ++;
                                                    }
                                                }
                                                if(yc == 3){
                                                    int ty = Integer.parseInt(value.substring(0 , 3));
                                                    if(ty >= 150 && ty <= 193){
                                                        fc ++;
                                                    }
                                                }

                                            }}
                                    }
                                    break;
                                case "hcl":
                                    if(value.length() == 7){
                                        if(value.charAt(0) == 35) {
                                            int yc = 0;
                                            for (int ql = 1; ql < 7; ql++) {
                                                if (value.charAt(ql) > 47 && value.charAt(ql) < 58) {
                                                    yc++;
                                                }
                                                if (value.charAt(ql) > 96 && value.charAt(ql) < 103) {
                                                    yc++;
                                                }
                                            }
                                            if (yc == 6) {
                                                fc++;
                                            }
                                        }
                                    }

                                    break;
                                case "ecl":
                                    int em = 0;
                                    for(int ql = 0; ql < 7; ql++){
                                        if(value.equals(eyes[ql])){
                                            em ++;
                                        }
                                    }
                                    if(em == 1){
                                        fc ++;
                                    }
                                    break;
                                case "pid":
                                    if(value.length() == 9) {
                                        int yc = 0;
                                        for (int ql = 0; ql < 9; ql++) {
                                            if (value.charAt(ql) > 47 && value.charAt(ql) < 58) {
                                                yc++;
                                            }
                                        }
                                        if (yc == 9) {
                                            fc++;
                                        }
                                    }
                                    break;
                                case "cid":
                                    break;

                            }

                        }
                        if(fc == 7){
                            valid ++;
                        }
                        thisDoc = "";
                    }
                }
                System.out.println("Number of valid passports:" + valid);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



