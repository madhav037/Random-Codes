import java.util.Arrays;
import java.util.Scanner;

public class B18 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i <n; i++) {
                arr[i] = sc.nextInt();
            }
            int location = 0, element;
            System.out.print("element : ");
            element = sc.nextInt();
            Arrays.sort(arr);

            for (int i = 0; i < n; i++) {
                if (arr[i] == element) {
                    location = i;
                    break;
                }
            }

            for (int i = location; i < n-1; i++) {
                arr[i] = arr[i+1];
            }

            for (int i = 0; i <n - 1; i++) {
                System.out.println(arr[i]);
            }
        }
    }

