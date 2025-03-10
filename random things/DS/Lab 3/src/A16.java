import java.util.Scanner;

public class A16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n; i++) {
            arr[i] = sc.nextInt();
        }
        int location;
        System.out.print("position : ");
        location = sc.nextInt();

        for (int i = location; i < n-1; i++) {
            arr[i] = arr[i+1];
        }

        for (int i = 0; i <n - 1; i++) {
            System.out.println(arr[i]);
        }
    }
}
