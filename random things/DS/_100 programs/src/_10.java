//WAP to find a prime number between range (range should be entered by user).
import java.util.Scanner;

public class _10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.print("Enter Start value : ");
        int start = sc.nextInt();
        System.out.print("Enter End value : ");
        int end = sc.nextInt();

        for (int i = start; i <= end; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.print(i + " ");
            }else {
                count = 0;
            }
        }
    }
}
