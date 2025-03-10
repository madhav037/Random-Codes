//WAP to sort an Array using Bubble sort.
import java.util.Scanner;
public class _16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter digits in array (-01 to break) ");
        array arr = new array(5);
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

        for (int i = 0; i < arr.size()-1; i++) {
            for (int j = i; j < arr.size()-i-1; j++) {
                System.out.println("working...");
                if (arr.peek(j) > arr.peek(j+1)) {
                    int temp = arr.peek(j+1);
                    arr.change(arr.peek(j),j+1);
                    arr.change(temp,j);
                }
            }
        }
        System.out.print("sorted array is : ");
        arr.display();
    }
}
class array {
    int sizeOfArray;
    int[] arr;
    int[] newArr;
    int index;
    array (int sizeOfArray) {
        this.sizeOfArray = sizeOfArray;
        arr = new int[this.sizeOfArray];
        index = 0;
    }

    void push(int x) {
        if (index == sizeOfArray) {
            increaseSize(x);
        }else {
            arr[index++] = x;
        }
    }
    int size() {
        return index;
    }

    int peek(int i) {
        return arr[i];
    }

    void change(int x, int i) {
        arr[i] = x;
    }

    void display() {
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }

    void popAndInsertInMiddle(int start, int end) {
        int temp2 = arr[start];
        for (int j = end; j > start; j--) {
            int temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = temp;
        } // 0 1 2 3 4 5 6 7
        arr[start] = temp2;
    }


    private
    void increaseSize(int x) {
        sizeOfArray = 2*sizeOfArray;
        newArr = new int[sizeOfArray];
        System.arraycopy(arr,0,newArr,0,arr.length);
        arr = newArr;
        push(x);
    }
}

