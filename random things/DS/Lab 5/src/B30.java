import java.util.Scanner;

public class B30{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0, Acount = 0, Bcount = 0;
        String str;
        System.out.print("Enter String : ");
        str = sc.nextLine();

        Recognise2 rec = new Recognise2(str.length());

        while (i != str.length()) {
            rec.push(str.charAt(i));
            i++;
        }
        while (!rec.empty()) {
            char x = rec.pop();
            if (x == 'a') {
                Acount++;
            } else if (x == 'b') {
                Bcount++;
            }
        }

        if (Acount == Bcount) {
            System.out.println("Valid");
        }else {
            System.out.println("Not Valid");
        }
    }
}

class Recognise2 {
    int TOP = -1;
    int N;
    char [] s;

    Recognise2 (int N) {
        this.N = N;
        s = new char[N];
    }

    void push(char x) {
        if (TOP >= N) {
            System.out.println("StackOverflow");
        }else {
            s[++TOP] = x;
        }
    }

    char pop() {
        if (TOP < 0) {
            System.out.println("StackUnderflow");
            return ' ';
        }else {
            return  s[TOP--];
        }
    }

    boolean empty() {
        return TOP < 0;
    }
}
