#include<iostream>
using namespace std;

//base class
class animals {
    public:
        void animalSounds() {
            cout<< "the animal makes sound\n";
        }
};

//derived class
class pig : public animals {
    public:
        void animalSounds() {
            cout<< "pigs makes sound\n";
        }
};

//derived class
class dog : public animals {
    public:
        void animalSounds() {
            cout<< "dogs makes sound\n";
        }
};


int main() {
    animals myAnimal;
    dog myDog;
    pig myPig;

    myAnimal.animalSounds();
    myDog.animalSounds();
    myPig.animalSounds();

    return 0;
}