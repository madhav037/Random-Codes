import java.util.Scanner;
import java.util.Stack;

public class B33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input infix string : ");
        StringBuilder input = new StringBuilder(sc.nextInt());
        System.out.println("Postfix is : " + toPostfix(input));
    }

    public static StringBuilder toPostfix(StringBuilder input) {
        StringBuilder output = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char infix = input.charAt(i);
//            if (isNotDigit(infix)) {
////                while (precedence(infix) >= precedence(st.peek())) {
//
//                }
//            }else {
//                output.append(infix);
//            }
//        }
//        return output;
        }

//    public static boolean isNotDigit(char i) {
//        if (i == '+' ||i == '-' ||i == '*' ||i == '/' ||i == '^') {
//            return true;
//        }else {
//            return false;
//        }
//    }
        return output;
    }
}


