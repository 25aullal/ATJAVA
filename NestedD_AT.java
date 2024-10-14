import java.util.Scanner;

public class NestedD_AT {
    static public void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please print a number from 1 to 3999: ");
//Declarations
        int num = in.nextInt();
        int Mcount = 0;
        int Ccount = 0;
        int Xcount = 0;
        int Icount = 0;
        String roman = "";
//Validation
        if (num < 1 || num > 3999) {
        System.out.printf("The number %d does not fit contraints.", num);
        }
//Thousands
        if (((num)/1000) >= 0) {
            Mcount = (num)/1000;
            num -= Mcount*1000;
                if (Mcount >= 1) {
                    roman+="M";
                    Mcount -- ;
                }
                if (Mcount >= 1) {
                    roman+="M";
                    Mcount -- ;
                }
                if (Mcount >= 1) {
                    roman+="M";
                    Mcount -- ;
                }
        } 
        if ((num-900) >= 0) {
            num -= 900;
            roman+= "CM";
        }
        if ((num-500) >= 0) {
            num -= 500;
            roman+= "D";
        }
        if ((num-400) >= 0) {
            num -= 400;
            roman+= "CD";
        }
//Hundreds
        if (((num)/100) >= 0) {
            Ccount = (num)/100;
            num -= Ccount*100;
            if (Ccount >= 1) {
                roman+="C";
                Ccount -- ;
            }
            if (Ccount >= 1) {
                roman+="C";
                Ccount -- ;
            }if (Ccount >= 1) {
                roman+="C";
                Ccount -- ;
            }
        } 
        if ((num-90) >= 0) {
            num -= 90;
            roman+= "XC";
        }
        if ((num-50) >= 0) {
            num -= 50;
            roman+= "L";
        }
        if ((num-40) >= 0) {
            num -= 40;
            roman+= "XL";
        }
//Tens
        if (((num)/10) >= 0) {
            Xcount = (num)/10;
            num -= Xcount*10;
            if (Xcount >= 1) {
                roman+="X";
                Xcount -- ;
            }
            if (Xcount >= 1) {
                roman+="X";
                Xcount -- ;
            }
            if (Xcount >= 1) {
                roman+="X";
                Xcount -- ;
            }
        } 
        if ((num-9) >= 0) {
            num -= 9;
            roman+= "IX";
        }
        if ((num-5) >= 0) {
            num -= 5;
            roman+= "V";
        }
        if ((num-4) >= 0) {
            num -= 4;
            roman+= "IV";
        }
//Ones
        if ((num/1) >= 0) {
            Icount = num;
            num -= Icount;
            if (Icount >= 1) {
                roman+="I";
                Icount -- ;
            }
            if (Icount >= 1) {
                roman+="I";
                Icount -- ;
            }
            if (Icount >= 1) {
                roman+="I";
                Icount -- ;
            }
        }
//Output
        System.out.println(roman);
    }
}        