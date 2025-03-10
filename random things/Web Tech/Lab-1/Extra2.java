import java.util.Scanner;

public class Extra2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        boolean flag = true;
        s = sc.nextLine();

        for (int i = 0; i < s.length(); i++){
            int rev = s.length() - i - 1;
            if (s.charAt(i) == s.charAt(rev)){
                flag = true;
            }
            else {
                flag = false;
            }
        }

        if (flag == false) {
            System.out.println("no");
        }
        else {
            System.out.println("yes");
        }
    }
}
