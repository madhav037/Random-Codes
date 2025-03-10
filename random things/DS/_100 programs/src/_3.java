//WAP to find a Factor of a given number (iterative and recursive)
import java.util.Scanner;
public class _3 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        n = sc.nextInt();
        System.out.println("Without recursion :");
        for (int i =1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }

        System.out.println("With recursion :");
        factor(n,1);
    }

    public static void factor(int n, int i) {
        if (i <= n ) {
            if (n % i == 0) {
                System.out.println(i);
            }
            factor(n,(i+1));
        }
    }
}
