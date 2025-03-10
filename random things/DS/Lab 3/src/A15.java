import java.util.Scanner;

public class A15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i <n; i++) {
            arr[i] = sc.nextInt();
        }
        int element, location, temp = arr[0];
        System.out.print("element : ");
        element = sc.nextInt();
        System.out.print("position : ");
        location = sc.nextInt();

        for (int i = n-1; i >= location-1; i--) {
            arr[i+1] = arr[i];
        }
        arr[location-1] = element;

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
