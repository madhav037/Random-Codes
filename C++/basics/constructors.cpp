#include<iostream>      //A constructor in C++ is a special method that is automatically called when an object of a class is created.
using namespace std;    //To create a constructor, use the same name as the class, followed by parentheses ():

class constructors{                 //the class
    public:                         //access specifier
        constructors() {            //constructor
            cout<< "hello world!\n";
        }
};  //Note: The constructor has the same name as the class, it is always public, and it does not have any return value.   


class parametersCar{
    public:         //Note: By default, all members of a class are "private" if you don't specify an access specifier:
        string brand;
        string model;
        int year;
        parametersCar(string x, string y, int z) {      //constructor with parameters
            brand = x;
            model = y;
            year = z;
        }
};    

int main() {
    constructors myObj;             //create an object of constructor(i.e. class)(this is call the constructor)

    parametersCar car1("Audi", "R8", 2004);

    cout<< car1.brand << " " << car1.model << " " << car1.year << "\n";

    return 0;
}