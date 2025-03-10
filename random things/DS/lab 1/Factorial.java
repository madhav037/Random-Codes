import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        int n, ans = 1;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int  i = 0; i <=n; i++ ) {
            ans *= i;
        }
        System.out.println(ans);
    }
}
