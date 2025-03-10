import java.util.Scanner;

//WAP to find a total odd and total even digit of a given number.
public class _8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int digit, rem = 0, Ecount = 0, Ocount = 0;
        System.out.print("Enter digit : ");
        digit = sc.nextInt();
        while(digit > 0) {
            rem = digit % 10;
            if (rem % 2 == 0) {
                System.out.println(rem + " is Even");
                Ecount++;
            }
            else {
                System.out.println(rem + " is Odd");
                Ocount++;
            }
            digit /= 10;
        }

        System.out.println("Total Odd are - " + Ocount + " Even are - " + Ecount);
    }
}
