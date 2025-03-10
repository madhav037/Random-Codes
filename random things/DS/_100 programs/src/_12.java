//WAP to find Max, Min, Average of n numbers, n should be taken from user and all n value should be taken from user
// (Note that you are not allowed to use an array for this)
import java.util.Scanner;

public class _12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = 0, max = 0, sum = 0, n, num;
        double avg;
        System.out.print("Enter total number : ");
        n = sc.nextInt();
        for (int i = 0; i < n ; i++) {
            System.out.print("Enter num : ");
            num = sc.nextInt();
            sum += num;
            if (i == 0) {
                min = num;
                max = num;
            }
            if (min > num) {
                min = num;
            }
            if (max < num) {
                max = num;
            }
        }
        avg = sum / (double)n;
        System.out.println("min is - " + min);
        System.out.println("max is - " + max);
        System.out.println("sum is - " + sum);
        System.out.println("avg is - " + avg);
    }
}
