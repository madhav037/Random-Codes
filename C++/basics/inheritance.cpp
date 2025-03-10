#include<iostream>
using namespace std;

//base class
class vehicle {
    public:
        string brand = "Ford";

        void honk() {
            cout<< "pppeee! pppeee!";
        }
};

//derived class
class car: public vehicle {
    public:
    string model = "Mustang";
};

int main() {

    car first;
    first.honk();
    cout<< first.brand << " " << first.model;

    return 0;
}

/*Why And When To Use "Inheritance"?
- It is useful for code reusability: reuse attributes and methods of an existing class when you create a new class.*/