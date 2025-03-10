import java.util.Scanner;
public class AreaOfCircle {
        public static void main(String[] args) {
            int r;
            Scanner sc = new Scanner(System.in);
            r = sc.nextInt();
            System.out.println(Math.PI * r *r);
        }
}