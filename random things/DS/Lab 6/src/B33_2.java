import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.Stack;

public class B33_2 {
    public static void main(String[] args) {
        String INFIX;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix string : ");
        INFIX = sc.nextLine();
        StringBuilder temp = new StringBuilder(INFIX);
        temp.append(") ");
        String finalInfix = String.valueOf(temp);
        System.out.println("POSTFIX : " + toPostfix(finalInfix));
    }

    public static StringBuilder toPostfix(String INFIX) {
        StringBuilder POLISH = new StringBuilder();
        Stack<Character> st = new Stack<>();
        st.push('(');
        int rank = 0, i = 1;
        char NEXT = INFIX.charAt(0);
        while(NEXT != ' ') {
            while (stackPrecedence(st.peek()) > inputPrecedence(NEXT)) {
                char temp = st.pop();
                POLISH.append(temp);
                rank += rank(temp);
                if (rank < 1) {
                    return new StringBuilder("INVALID due to rank");
                }
            }

            if (stackPrecedence(st.peek()) != inputPrecedence(NEXT)) {
                st.push(NEXT);
            }else {
                st.pop();
            }
            NEXT = INFIX.charAt(i);
            i++;
        }
        if (rank != 1) {
            return new StringBuilder("INVALID due to rank 2");
        }else {
            return POLISH;
        }

    }

    public static int inputPrecedence(char i) {
        if (i == '+' || i == '-') {
            return 1;
        } else if (i == '*' || i == '/') {
            return 3;
        } else if (i == '^') {
            return 6;
        }else if (i == '(') {
            return 9;
        }else if (i == ')') {
            return 0;
        }else {
            return 7;
        }
    }
    public static int stackPrecedence(char i) {
        if (i == '+' || i == '-') {
            return 2;
        } else if (i == '*' || i == '/') {
            return 4;
        } else if (i == '^') {
            return 5;
        }else if (i == '(') {
            return 0;
        }else {
            return 8;
        }
    }

    public static int rank(char i) {
        if (i == '+' || i == '-' || i == '*' || i == '/' || i == '^') {
            return -1;
        }else if (i != '(' || i != ')') {
            return 1;
        }else {
            return 0;
        }
    }
}
