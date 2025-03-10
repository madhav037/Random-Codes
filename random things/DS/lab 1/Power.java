import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        int base, power, ans = 1;
        Scanner sc = new Scanner(System.in);
        base = sc.nextInt();
        power = sc.nextInt();
        for (int i = 1; i <= power; i++) {
            ans = ans * base;
        }
        System.out.println("base : "+ base +" Power : " + power + " ans : " + ans);
    }
}
