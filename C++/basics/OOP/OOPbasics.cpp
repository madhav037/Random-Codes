#include<iostream>

using namespace std;

class Abstractemployee{     //abstraction
    virtual void Getpromotion()=0;
};

class employee:Abstractemployee {             //class
private: 
        string name;
        string company;
        int age;
public:                 //public protected private

        void setname(string Name){      //set method (encaplusation)
            name = Name;                /*this is so that anyone outside class can access the values*/
        }
        string getname(){                 ////get method (encaplusation)
            return name;
        }
        void setcompany(string Company){
            company = Company;
        }
        string getcompany(){
            return company;
        }
        void setage(int Age){
            if(Age>=18){
            age = Age;  }
        }
        int getage(){
            return age;
        }
        
        void introduceYourself(){       //function
            cout<<"Name - "<<name<<" age - "<<age<<" company - "<<company<<"\n";
        }

        employee(string Name, string Company, int Age){     //constructor /*name of constructor should be same as class and there should be no return type (not even void)*/
            name = Name;
            company = Company;
            age = Age;
        }                                                  //constructor end

        void Getpromotion(){
            if(age>30){
                cout<<name<<" you got promotion\n";
            }
            else{
                cout<<"better luck next time, "<<name<<"\n";
            }
        }
};

class Developer: employee{
public: 
    string FavProgrammingLanguage;
    Developer(string Name, string Company, int Age, string favProgrammingLanguage):employee(Name, Company, Age){
        FavProgrammingLanguage = favProgrammingLanguage;
    }

    void Fixbug(){
        cout<<"fixed bug!\n";
    }
};

int main() {
    employee employee1 = employee("Madhav" , "Amazon" , 19);
    employee1.introduceYourself();

    employee employee2 = employee("notMadhav", "notAmazon", 20);
    employee2.introduceYourself();

    employee1.setage(34);
    cout<<"age is "<<employee1.getage()<<"\n";

    employee1.Getpromotion();
    employee2.Getpromotion();

    Developer d = Developer("maadhav", "google", 19, "C++");
    d.Fixbug();
}