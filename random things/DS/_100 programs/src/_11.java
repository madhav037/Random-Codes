//WAP to find weather given number is Armstrong number is not.
import java.util.Scanner;

public class _11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rem = 0, ans = 0, digit_copy;
        System.out.print("Enter digit : ");
        int digit = sc.nextInt();
        digit_copy = digit;
        while (digit > 0) {
            rem = digit % 10;
            ans += (rem * rem * rem);
            digit /= 10;
        }

        if (digit_copy == ans) {
            System.out.println(digit_copy + " is armstrong number");
        }
        else {
            System.out.println(digit_copy + " is not armstrong number");
        }
    }
}
