import java.util.Scanner;

public class B13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int flag = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    flag = 1;
                    break;
                }
            }
        }
        if (flag == 1) {
            System.out.println("contains duplicate");
        }
        else {
            System.out.println("not contain");
        }
    }
}
