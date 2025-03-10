import java.util.Scanner;

public class A22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a , b;
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println("after swap");
        A22 swap = new A22();
        swap.swap(a,b);
    }
    public void swap(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("a : " + a);
        System.out.println("b : " + b);
    }
}
