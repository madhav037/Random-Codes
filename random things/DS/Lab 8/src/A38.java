import java.util.Scanner;

public class A38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Queue : ");
        int N = sc.nextInt();
        queue q = new queue(N);
        while(true) {
            System.out.print("Enter 1 to insert 2 to delete 3 to display -01 to leave : ");
            int num = sc.nextInt();
            if (num == -01) {
                break;
            }

            if (num == 1) {
                System.out.print("Enter number : ");
                int number = sc.nextInt();
                q.Enqueue(number);
            } else if (num == 2) {
                int temp = q.Dequeue();
                System.out.println("Element removed : " + temp);
            } else if (num == 3) {
                System.out.println(" +");
                q.display();
            }
        }
        sc.close();
    }
}
class queue {
    int F = -1;
    int R = -1;
    int N;
    int[] Q;
    queue(int N) {
        this.N = N+1;
        Q = new int[this.N];
    }

    void Enqueue(int Y) {
        if (R > N) {
            System.out.println("Overflow");
        }else {
            Q[++R] = Y;
        }
        if (F == -1) {
            F = 0;
        }
    }

    int Dequeue() {
        int Y = 0;
        if (F == -1) {
            System.out.println("Underflow");
            return 0;
        }else {
            Y = Q[F];
        }

        if (F == R) {
            F = R = -1;
        }else {
            F++;
        }
        return Y;
    }

    void display() {
        for (int i = F; i <= R; i++) {
            System.out.print(Q[i] + " ");
        }
    }
    
}
