//WAP to sort an Array using insertion sort.
//!!pending!!
import java.util.Scanner;

public class _17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter digits in array (-01 to break) ");
        array arr = new array(5); // array class is in _16
        while(true) {
            System.out.print("Enter element : ");
            int num = sc.nextInt();
            if (num == -01) {
                break;
            }
            arr.push(num);
        }
        System.out.print("array is : ");
        arr.display();


        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size()-i; j++) {
                for (int k = j; k < i; k++) {
                    if (arr.peek(i) == arr.peek(j)) {
                        break;
                    }else if (arr.peek(j) > arr.peek(i)) {

                    }
                }
            }
        }
        System.out.print("sorted array : ");
        arr.display();
    }
}
