import java.util.Scanner;

public class A20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] m1 = new int[2][2];
        int[][] m2 = new int[2][2];
        int[][] fm = new int[2][2];

        System.out.println("matrix 1");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("row : " + i + " col : " + j + " : ");
                m1[i][j] = sc.nextInt();
            }
        }

        System.out.println("matrix 2");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("row : " + i + " col : " + j + " : ");
                m2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                fm[i][j] = m1[i][j] + m2[i][j];
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(fm[i][j] + " ");
            }
            System.out.println();
        }
    }
}