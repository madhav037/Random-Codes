//WAP to find a Multiplication of 2 Matrix (dimension and value should be entered by user)
import java.util.Scanner;

public class _13 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter row of matrix 1 - ");
        int m1_row = sc.nextInt();
        System.out.print("Enter col of matrix 1 - ");
        int m1_col = sc.nextInt();
        System.out.print("Enter row of matrix 2 - ");
        int m2_row = sc.nextInt();
        System.out.print("Enter col of matrix 2 - ");
        int m2_col = sc.nextInt();
        if (m1_col != m2_row) {
            System.out.print("Enter value again multi cannot happen ");
        }
        else {
            int[][] m1 = new int[m1_row][m1_col];
            int[][] m2 = new int[m2_row][m2_col];
            int[][] fm = new int[m1_row][m2_col];

            System.out.println("matrix 1");
            for (int i = 0; i < m1_row; i++) {
                for (int j = 0; j < m1_col; j++) {
                    System.out.print("row : " + i + " col : " + j + " : ");
                    m1[i][j] = sc.nextInt();
                }
            }

            System.out.println("matrix 2");
            for (int i = 0; i < m2_row; i++) {
                for (int j = 0; j < m2_col; j++) {
                    System.out.print("row : " + i + " col : " + j + " : ");
                    m2[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < m1_row; i++) {
                for (int j = 0; j < m2_row; j++) {
                    for (int k = 0; k < m1_row; k++) {
                        fm[i][k] += (m1[i][j] * m2[j][k]);
                    }
                }
            }

            for (int i = 0; i < m1_row; i++) {
                for (int j = 0; j < m2_col; j++) {
                    System.out.print(fm[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
