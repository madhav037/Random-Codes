//WAP to calculate an angle between hour and minute hand. (Hours and minutes should be taken from user).
import java.util.Scanner;

public class _14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Hour - ");
        float hour = sc.nextFloat();
        System.out.print("Enter the Min - ");
        float min = sc.nextFloat();

        float angleOfHour , angleOfMin;

        if (hour >= 12) {
            hour -= 12;
        }
        if (min >= 60) {
            min -= 60;
        }

        angleOfHour = hour*30 + min/2;
        angleOfMin = min*6;

        System.out.println("angle between hour and min =" + Math.abs(angleOfHour-angleOfMin));
    }
}
