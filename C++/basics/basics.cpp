#include<iostream>      //use g++ .\fileName.cpp and .\a.exe to compile and run program
#include<string>        //to use string
#include<cmath>
using namespace std;

/*if you want to not write namespace then you can write std -keyword and :: - operator for string (and cout) objects
it then goes like :  std::string greeting = "Hello";
                    std::cout << greeting; */

    // Declare a structure named "car"
struct car {
  string brand;
  string model;
  int year;
};

void myFunction();

   void myCountry(string country = "Norway") {
    cout << country << "\n";
    }

        int plusFunc(int x, int y) {
  return x + y;
}

double plusFunc(double x, double y) {
  return x + y;
}


int mus(int k) {
  if (k > 0) {
    return k + mus(k - 1);
  } else {
    return 0;
  }
}

int main() {
    cout<< "hello world!\n";
    cout<< "okay so this is C++\n"; 

    cout<< "hello world!" << endl;               //"endl" is similar to "\n" i.e. to make new line
    cout<< "okay so this is C++"<< endl;         // /t - tab, // - /, /" - double quotes

    int num = 7;                                 //similar with double, char, string and boolean
    cout<< num << endl;
    int num1;
    num1 = 3;
    cout<< num1 << endl;
    cout<< "this is " << num1 << " an example" << "\n";
    int sum = num + num1;
    cout<< sum <<"\n";
    //other methods
    int x, y, z; //or int x = 2, y = 3, z = 4; 
    x = y = z = 5;
    cout<< x << y << z;
    const int pi = 3.14; //for declaring constant

    int a;                                       //similar with other data types
    cout<< "enter num : ";
    cin>> a;
    cout<< "num is " << a <<"\n";
    
    string greetings = "hello\n";
    cout<< greetings;
    string firstName = "madhav";
    string lastName = "lehru";
    string fullName = firstName + " " + lastName;
    cout<< fullName << endl;
    string _fullName = firstName.append(lastName); //to join 2 strings
    cout<< _fullName << "\n";                    //lly if you put string as "10" and "20" and then add it will show 1020

    string txt = "svadbtbfgbabbfbtrs";
    cout<< "length or size of string is " <<txt.length() << "\n"; //OR
    cout<< "length or size of string is " <<txt.size() << "\n";

    string _accessString  = "Hello";
    cout<< _accessString[0] << endl;
    cout<< _accessString[1] << endl;
    _accessString[0] = 'j';
    cout<< _accessString;

    cout << sqrt(64) << endl;
    cout << round(2.6) << endl;
    cout << log(2) << endl;

                                                    //if else else if switch and ternary operator are same as C
                                                    //and while do while and for loops are same as C
                                                    //this is foreach loop
                                                    /*syntax : for (type variableName : arrayName) {
                                                                        code block
                                                                }*/
    int myNumbers[5] = {10, 20, 30, 40, 50};
        for (int i : myNumbers) {
            cout << i << "\n";
        }
                                                    //break and conti also same

    string cars[4] = {"Audi", "Jaguar", "BMW", "mercedes"};
    cout<< cars[3] << endl;
    cars[2] = "rolls royls";
    cout<< cars[2] << "\n";

    for (int i = 0; i < 4; i++)
    {
        cout<< i << " = " << cars[i] << "\n";
    }
    cout<< sizeof(cars) << "\n";    //output here will be 96 cause it gives answer in bytes so 
    int getArrayLength = sizeof(cars) / sizeof(string);
    cout<< getArrayLength;

                                                    //looping through multidimentional array
    string letters[2][4] = {
            { "A", "B", "C", "D" },
            { "E", "F", "G", "H" }
    };

    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 4; j++) {
            cout << letters[i][j] << "\n";
        }
    }   

                             //we use a multi-dimensional array to represent a small game of Battleship:

            // We put "1" to indicate there is a ship.
            bool ships[4][4] = {
            { 0, 1, 1, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 1, 0 }
            };

            // Keep track of how many hits the player has and how many turns they have played in these variables
            int hits = 0;
            int numberOfTurns = 0;

            // Allow the player to keep going until they have hit all four ships
            while (hits < 4) {
            int row, column;

            cout << "Selecting coordinates\n";

            // Ask the player for a row
            cout << "Choose a row number between 0 and 3: ";
            cin >> row;

            // Ask the player for a column
            cout << "Choose a column number between 0 and 3: ";
            cin >> column;

            // Check if a ship exists in those coordinates
            if (ships[row][column]) {
                // If the player hit a ship, remove it by setting the value to zero.
                ships[row][column] = 0;

                // Increase the hit counter
                hits++;

                // Tell the player that they have hit a ship and how many ships are left
                cout << "Hit! " << (4-hits) << " left.\n\n";
            } else {
                // Tell the player that they missed
                cout << "Miss\n\n";
            }

            // Count how many turns the player has taken
            numberOfTurns++;
            }

            cout << "Victory!\n";
            cout << "You won in " << numberOfTurns << " turns";



                                                    // Create a car structure and store it in myCar1;
  car myCar1;
  myCar1.brand = "BMW";
  myCar1.model = "X5";
  myCar1.year = 1999;

                                                     // Create another car structure and store it in myCar2;
  car myCar2;
  myCar2.brand = "Ford";
  myCar2.model = "Mustang";
  myCar2.year = 1969;
 
                                                     // Print the structure members
  cout << myCar1.brand << " " << myCar1.model << " " << myCar1.year << "\n";
  cout << myCar2.brand << " " << myCar2.model << " " << myCar2.year << "\n";



                                        //A reference variable is a "reference" to an existing variable, and it is created with the & operator:
  string food = "Pizza";
  string &meal = food;

  cout << food << "\n";  // Outputs Pizza 
  cout << meal << "\n";  // Outputs Pizza
    
                                                    //the & operator is also used to get the memory address 
  cout<< &food << "\n";

                                                    //pointer variable(*) stores memory address in itself while & shows

  string *ptr = &food;
                                                    // Reference: Output the memory address of food with the pointer
  cout<< ptr << "\n";
                                                    // Dereference: Output the value of food with the pointer
  cout << *ptr << "\n";


                            //You can also change the pointer's value. But note that this will also change the value of the original variable:
                            // Output the value of food (Pizza)
    cout << food << "\n";

                            // Output the memory address of food (0x6dfed4) 
    cout << &food << "\n";

                            // Access the memory address of food and output its value (Pizza)
    cout << *ptr << "\n";

                            // Change the value of the pointer
    *ptr = "Hamburger";

                            // Output the new value of the pointer (Hamburger)
    cout << *ptr << "\n";

                            // Output the new value of the food variable (Hamburger)
    cout << food << "\n";


    myFunction(); // call the function


                                                    //default parameter
  myCountry("Sweden");
  myCountry("India");
  myCountry();
  myCountry("USA");


int myNum1 = plusFunc(8, 5);
  double myNum2 = plusFunc(4.3, 6.26);
  cout << "Int: " << myNum1 << "\n";
  cout << "Double: " << myNum2 << "\n";

    int result = mus(10);
  cout << result << "\n";

/*10 + mus(9)
10 + ( 9 + mus(8) )             (mus = sum)
10 + ( 9 + ( 8 + mus(7) ) )
...
10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 + mus(0)
10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 + 0
Since the function does not call itself when k is 0, the program stops there and returns the result.

*/

    return 0;
}

// Create a function
    void myFunction() {
    cout << "function!";
    }


