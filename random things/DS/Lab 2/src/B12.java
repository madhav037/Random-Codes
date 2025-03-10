import java.util.Scanner;

public class B12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int min = arr[0], pos = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                pos = i;
                min = arr[i];
            }
        }
        System.out.println(pos);
    }
}
