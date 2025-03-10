import java.util.Scanner;
import java.util.Stack;

public class B37 extends B33_3{
    public static void main(String[] args) {
        String INFIX;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix string : ");
        INFIX = sc.nextLine();
        StringBuilder infix = new StringBuilder(INFIX);
        infix.reverse();
        infix.append(") ");
        String PINFIX = String.valueOf(infix);
        String Finalans = String.valueOf(toPostfix(PINFIX));
        System.out.println("POSTFIX : " + Finalans);
        System.out.println("Final ans : " + evaluatePrefix(Finalans));
    }

    public static int evaluatePrefix(String value) {
        int i = value.length()-1;
        Stack<Integer> stack = new Stack<>();
        while (i >= 0) {
            char temp = value.charAt(i);
            i--;
            if (Character.isLetterOrDigit(temp)) {
                stack.push(Character.getNumericValue(temp));
            }else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
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
