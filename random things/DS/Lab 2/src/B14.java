import java.util.Scanner;

public class B14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int first , second, a = 0;
        first = sc.nextInt();
        second = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (arr[i] == first) {
                a = i;
                arr[i] = second;
            }
        }
        System.out.println("arr index = " + a);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
