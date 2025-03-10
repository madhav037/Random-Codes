#include<iostream>
using namespace std;


//multilevel inheritance
//base class
class grandfather {
    public:
        void myFunction() {
            cout<< "hoo hoo hoo\n";
        }
};
//derived class
class father: public grandfather {
};

//derived class
class child: public father {
};


//multiple inheritance
//base class
class myClass {
    public:
    void myFunction() {
        cout<< "this is from base class\n";
    }
};

//another base class
class otherClass {
    public:
    void myOtherFunction() {
        cout<< "this is from other base class\n";
    }
};

//derived class
class derivedClass: public myClass, public otherClass {
};


//protected is used
// Base class
class Employee {
  protected: // Protected access specifier
    int salary;
};

// Derived class
class Programmer: public Employee {
  public:
    int bonus;
    void setSalary(int s) {
      salary = s;
    }
    int getSalary() {
      return salary;
    }
};

int main() {
    child myObj;
    myObj.myFunction();


    derivedClass myObj2;
    myObj2.myFunction();
    myObj2.myOtherFunction();

    Programmer myObj3;
    myObj3.setSalary(5000000);
    myObj3.bonus = 15000;
    cout<< "salary" << myObj3.getSalary() << "\n";
    cout<< "bonus" << myObj3.bonus << "\n";

    return 0;
}



