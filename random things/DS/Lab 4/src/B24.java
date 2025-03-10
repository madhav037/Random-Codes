import java.util.Scanner;

public class B24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int endrollment_num = 0;
        String name = "";
        int sem = 0;
        float CPI = 0;

        StudentDetails[] sd = new StudentDetails[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("end num : ");
            endrollment_num = sc.nextInt();
            System.out.print("name : ");
            name = sc.next();
            System.out.print("sem : ");
            sem = sc.nextInt();
            System.out.print("cpi : ");
            CPI = sc.nextFloat();
            sd[i] = new StudentDetails(endrollment_num, name, sem, CPI);

        }

        for (int i = 0; i < 5; i++) {
            sd[i].printDetails();
        }
    }
}

class StudentDetails {
    int endrollment_num;
    String name;
    int sem;
    float CPI;

    StudentDetails(int endrollment_num, String name, int sem, float CPI) {
        this.endrollment_num = endrollment_num;
        this.name = name;
        this.sem = sem;
        this.CPI = CPI;
    }

    public void printDetails() {
        System.out.println(endrollment_num);
        System.out.println(name);
        System.out.println(sem);
        System.out.println(CPI);
    }
}
