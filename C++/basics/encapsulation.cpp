#include<iostream>
using namespace std;

class employee {
    private:
        int salary; //private arttibute

    public:
        //setter
        void setSalary(int s) { 
            salary = s;
        }

        //getter
        int getSalary() {
            return salary;
        }

};

int main() {
    employee num1;
    num1.setSalary(5000000);
    cout<< num1.getSalary();
    return 0;

}

//Why Encapsulation?
//It is considered good practice to declare your class attributes as private (as often as you can). Encapsulation ensures better control of your data, because you (or others) can change one part of the code without affecting other parts
//Increased security of data
