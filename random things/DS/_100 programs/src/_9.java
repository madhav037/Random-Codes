import java.util.Scanner;

//WAP to find whether a number is Odd or Even without using a % operator.
public class _9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int num = sc.nextInt();
        int i = 1;
        boolean flag = false;
        while (i < num) {
            if (2 * i == num) {
                flag = true;
                break;
            }
            i++;
        }

        if (flag == true) {
            System.out.println("Even");
        }
        else {
            System.out.println("Odd");
        }
    }
}
