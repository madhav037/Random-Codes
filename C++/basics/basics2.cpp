#include<iostream>
using namespace std;

class myClass       //the class
{
public:             //access specifier
    int myNum;      //attribute
    string myString;//attribute

    void myMethod() {       //method or function defined inside of class
        cout<< "method defined inside of class\n";   
    }

    void myMethod2();       //method/function declaration
};

    void myClass::myMethod2() {     //method defination outside of class
        cout<< "this method is defined outside of class\n";
    }




class car
{
    public:
    int speed(int maxSpeed);
};

    int car::speed(int maxSpeed) {
        return maxSpeed;
    }


int main() {
    myClass myObj;      //create an object of myClass

    myObj.myNum = 15;       //access attributes and set values
    myObj.myString = "some text";
    
    cout<< myObj.myNum << "\n";     //print attribute values
    cout<< myObj.myString << "\n";

    //creating multiple objects of one class

    myClass myObj2;

    myObj2.myNum = 25;
    myObj2.myString = "some other text";

    cout<< myObj2.myNum << "\n" << myObj2.myString << "\n";

    myObj.myMethod();       //call the method
    myObj.myMethod2();       //call the method

    car obj;

    cout<< obj.speed(200) << "\n";

    return 0;
}