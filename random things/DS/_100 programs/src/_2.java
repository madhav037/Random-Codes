//WAP to find whether string is palindrome or not.
import java.util.Scanner;

public class _2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        boolean flag = true;
        System.out.print("Enter String : ");
        s = sc.nextLine();

        for (int i = 0; i < s.length(); i++){
            int rev = s.length() - i - 1;
            flag = s.charAt(i) == s.charAt(rev);
        }

        if (!flag) {
            System.out.println("no");
        }
        else {
            System.out.println("yes");
        }
    }
}
