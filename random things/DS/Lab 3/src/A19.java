import java.util.Scanner;

public class A19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, n2;
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        int[] farr = new int[n1+n2];
        System.out.println("Arr 1");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
            farr[i] = arr1[i];
        }
        
        System.out.println("Arr 2");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
            farr[n1+i] = arr2[i];
        }
        for (int i = 0; i < (n1+n2); i++) {
            System.out.println(farr[i]);
        }
    }
}
