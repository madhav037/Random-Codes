import java.util.Scanner;

public class A10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n, ans = 0;
        m = sc.nextInt();
        n = sc.nextInt();
        for (int i = m; i <= n; i++) {
            ans += i;
        }
        System.out.println(ans);
    }
}
