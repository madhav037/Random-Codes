//WAP to convert a Decimal number to BCD.
import java.util.Arrays;
import java.util.Scanner;
public class _15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter decimal number : ");
        double num = sc.nextDouble();

        String[] BCD_codes = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001", "dot"};
        int integer = 0, finalSize = 0;
        float decimal = 0;

        integer = (int) Math.floor(num);
        decimal = (float) (num - integer);

        String a = String.valueOf(decimal);
        a = a.substring(2);
        int decimalInt = Integer.parseInt(a);
        int size = (int) (Math.floor(Math.log10(num)) + 1);

        String[] intAnsArray = new String[size];

        int decisize = (int) (Math.floor(Math.log10(decimalInt)) + 1);

        if (decisize > 0) {
            String[] decAnsArray = new String[decisize];

            while (decimalInt > 0) {
                int temp = (decimalInt % 10);
                decAnsArray[decisize-1] = BCD_codes[temp];
                decimalInt /= 10;
                decisize--;
            }

            while (integer > 0) {
                int temp = integer % 10;
                intAnsArray[size-1] = BCD_codes[temp];
                integer/=10;
                size--;
            }

            finalSize = intAnsArray.length + decAnsArray.length;
            String[] ansArray = new String[finalSize];
            System.arraycopy(intAnsArray,0,ansArray,0,intAnsArray.length);
//            ansArray[intAnsArray.length+1] = BCD_codes[10];
            System.arraycopy(decAnsArray,0,ansArray,intAnsArray.length,decAnsArray.length);

            for (String j : ansArray) {
                System.out.print(j + " ");
            }
        }else {
            while (integer > 0) {
                int temp = integer % 10;
                intAnsArray[size-1] = BCD_codes[temp];
                integer/=10;
                size--;
            }

            for (String j : intAnsArray) {
                System.out.print(j + " ");
            }
        }
    }
}
