import java.util.Scanner;

//WAP to find a Fibonacci series up to n terms (n is entered by user) (iterative and recursive)
public class _7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of time to run : ");
        int a = sc.nextInt();
        int ans = 1;
        System.out.println("Without recursion");
        System.out.print("0 1 ");
//        System.out.println("1");
        int last = 0, Slast = 1;
        for (int i = 2; i < a; i++) {
            ans = last + Slast;
            last = Slast;
            Slast = ans;
            System.out.print(ans + " ");
        }
        System.out.println();
        System.out.println("with recursion");
        System.out.print("0 1 ");
        fibonaci(a,0,1);


    }
    public static void fibonaci(int n, int last, int Slast) {
//        System.out.print("0 1 ");
//        System.out.println("1");
        if (n-2 > 0) {
            int ans = last + Slast;
            last = Slast;
            Slast = ans;
            System.out.print(ans + " ");
            fibonaci((n-1),last,Slast);
        }
    }
}
