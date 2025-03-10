import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        int n, check = 1;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                check = 0;
            }
        }
        if (check == 1) {
            System.out.println("prime");
        }
        else {
            System.out.println("not prime");
        }
    }
}
