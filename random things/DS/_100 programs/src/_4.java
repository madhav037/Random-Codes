//WAP to find a factorial of a given integer (iterative and recursive)
import java.util.Scanner;

public class _4 {
    public static void main(String[] args) {
        int n, ans = 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        n = sc.nextInt();
        System.out.println("Without recursion :");
        for (int  i = 0; i <=n; i++ ) {
            ans *= i;
        }
        System.out.println(ans);

        System.out.print("Without recursion :");
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
