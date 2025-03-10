import java.util.Scanner;

public class A11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, sum = 0;
        double avg;
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        avg = (sum/n);
        System.out.println(avg);
    }
}
