import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, num = 0, check = 0,temp;
        System.out.print("Enter size of stack : ");
        N = sc.nextInt();
        stack st = new stack(N);

        while(true) {
            if (check == 6) {
                break;
            }
            System.out.print("Press 1 to push, 2 to pop, 3 to display, 4 to peep, 5 to change, 6 to leave : ");
            check = sc.nextInt();

            switch(check) {
                case 1 : System.out.print("Enter number - ");
                    num = sc.nextInt(); 
                    st.push(num);
                    System.out.println("ELEMENT PUSHED");
                    break;

                case 2 : temp = st.pop();
                    System.out.println("ELEMENT POPED - " + temp);
                    break;

                case 3 : st.display();
                    System.out.println("ELEMENT DISPLAYED");
                    break;

                case 4 : System.out.print("Enter element number - ");
                    num = sc.nextInt();
                    temp = st.peep(num);
                    System.out.println("ELEMENT PEEPED - " + temp);
                    break;
                
                case 5 : System.out.print("Enter element number- ");
                    num = sc.nextInt();
                    System.out.print("Enter value - ");
                    temp = sc.nextInt(); 
                    st.change(num,temp);
                    System.out.println("ELEMENT CHANGED");
                    break;
                case 6 : System.out.println("ok byee!");
                    break;
                default : System.out.println("Enter Correct value");
                    break;     
            }
        }
   }
}

class stack{
    int N;
    int TOP = -1;
    int[] s;

    stack(int N) {
        this.N = N;
        s = new int[N];
    }

    public void push(int x) {
        if (TOP >= N) {
            System.out.println("StackOverflowError");
        }
        else {
            s[++TOP] = x;
        }
    }

    public int pop() {
        if (TOP < 0) {
            System.out.println("StackUnderflowError");   
            return 0;
        }
        else {
            return s[TOP--];
        }
    }

    public void display() {
        if (TOP == -1) {
            System.out.println("Stack empty");
        }
        else{
            for (int i = TOP ; i >= 0; i--) {
                System.out.println("[ " + s[i] + " ]");
            }
        }
    }

    public int peep(int I) {
        if ((TOP - I + 1) < 0) {
            System.out.println("StackUnderflowError");
            return 0;
        }
        else {
            return s[TOP-I+1];
        }
    }

    public void change(int I, int X) {
        if ((TOP - I + 1) < 0) {
            System.out.println("StackUnderflowError");
        }
        else {
            s[TOP-I+1] = X;
        }    
    }
}