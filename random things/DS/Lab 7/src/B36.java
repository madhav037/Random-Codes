import java.util.Scanner;
import java.util.Stack;

public class B36 extends  B33_2{
    public static void main(String[] args) {
        String INFIX;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix string : ");
        INFIX = sc.nextLine();
        StringBuilder temp = new StringBuilder(INFIX);
        temp.append(") ");
        String finalInfix = String.valueOf(temp);
        String Finalans = String.valueOf(toPostfix(finalInfix));
        System.out.println("POSTFIX : " + Finalans);
        System.out.println("Final ans : " + evaluatePostfix(Finalans));
    }

    public static int evaluatePostfix(String value) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i <= value.length()-1) {
            char temp = value.charAt(i);
            i++;
            if (Character.isLetterOrDigit(temp)) {
                stack.push(Character.getNumericValue(temp));
            }else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int answer = performOperation(operand1, operand2, temp);
                stack.push(answer);
            }
        }
        return stack.pop();
    }

    static int performOperation(int a, int  b, char sign) {
        return switch (sign) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            case '^' -> (int) Math.pow(b, a);
            default -> 0;
        };
    }
}
