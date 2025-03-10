//EveryTime invalid String coming

import java.util.Scanner;
import java.lang.*;

public class A29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int nextChar = 0;
        String str;

        System.out.print("Enter String : ");
        str = sc.nextLine();

        recognise rec = new recognise(str.length()-1);
        char NEXT;
        int i = 0;

        rec.push('c');


        NEXT = str.charAt(i);
        i++;

        while(NEXT != 'c') {
            if (NEXT == ' ') {
                System.out.println("Invalid String");
                break;
            }
            else {
                rec.push(NEXT);
                NEXT = str.charAt(i);
                i++;
            }
        }
//        System.out.println(str.charAt(i));
        boolean flag = true;
        while(rec.peek() != 'c'){
            NEXT = str.charAt(i);
            char x = rec.pop();
            if(NEXT != x) {
                System.out.println("Invalid");
                flag = false;
                break;
            }
            i++;
        }
//        System.out.println(str.charAt(i));
        NEXT = str.charAt(i);
        if (NEXT == ' ' && flag == true) {
            System.out.println("VALID");
        }else {
            System.out.println("INVALID");
        }
//        rec.check(nextChar);
    }
}

class recognise{
    int N;
    int TOP = -1;
    char[] s;
//    char NEXT;
//    char check;
//    String str;

    recognise(int N) {
        this.N = N;
        s = new char[N];
    }

    public void push(char x) {
        if (TOP >= N) {
            System.out.println("StackOverflowError");
        }
        else {
            s[++TOP] = x;
        }
    }

    public char pop() {
        if (TOP < 0) {
            System.out.println("StackUnderflowError");
            return ' ';
        }
        else {
            return s[TOP--];
        }
    }

//    public void check(int nextChar) {
//        while (s[TOP] != 'c') {
//            NEXT = str.charAt(nextChar);
//            nextChar++;
//            check = pop();
//
//            if (NEXT != check) {
//                System.out.println("Invalid String");
//                break;
//            }
//        }
//
//        NEXT = str.charAt(nextChar);
//        if (NEXT == ' ') {
//            System.out.println("Valid String");
//        }
//        else {
//            System.out.println("Invalid String");
//        }
//    }
    char peek(){
        if (TOP < 0) {
            System.out.println("StackUnderflowError");
            return ' ';
        }
        else{
            return s[TOP];
        }
    }


}
