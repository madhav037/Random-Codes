import java.util.Scanner;

public class Extra1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, sum = 0;
        n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i+=2){
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
