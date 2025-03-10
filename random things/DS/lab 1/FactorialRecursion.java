import java.util.Scanner;

public class FactorialRecursion {
    public static void main(String[] args) {
        int n, ans;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = fact(n);
        System.out.println(ans);
    }
    public static int fact(int n) {
        if (n == 1) {
            return 1;
        }
        else{
            return (n * fact(n-1));
        }
    }
}
