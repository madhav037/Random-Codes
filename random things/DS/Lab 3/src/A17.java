import java.util.Arrays;
import java.util.Scanner;

public class A17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i <n; i++) {
            arr[i] = sc.nextInt();
        }
        int element, location=0, temp = arr[0];
        System.out.print("element : ");
        element = sc.nextInt();

//        Arrays.sort(arr);
        for (int i = 0; i < n; i++ ) {
            if (arr[i] >= element) {
                location = i;
                break;
            }
        }

        for (int i = n-1; i >= location; i--) {
            arr[i+1] = arr[i];
        }
        arr[location] = element;

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
