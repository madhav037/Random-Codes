import java.util.Scanner;

//WAP to find a summation of a digit of a given number. (Iterative and recursive)
public class _5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter digit : ");
        int a = sc.nextInt();
        int b = a, rem = 0, sum = 0;
        while(a > 0) {
            rem = a % 10;
            sum += rem;
            a /= 10;
        }

        System.out.println("Without Recursion");
        System.out.println(sum);

        System.out.println("With Recursion");
        sumation(b,0);
    }

    public static void sumation(int n, int ans) {
        if (n > 0) {
            int rem = n % 10;
            ans = ans + rem;
            sumation(n/10, ans);
        }
        else {
            System.out.println(ans);
        }
    }
}
