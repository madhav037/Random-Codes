#include<iostream>
#include<fstream>
using namespace std;

int main() {
/*To create a file, use either the "ofstream" or "fstream" class, and specify the name of the file.
To write to the file, use the insertion operator (<<).*/

    //create and open a text file
    ofstream Myfiles("fileName.txt");

    //write to the file
    Myfiles<< "i am writing something is file";

    //close the file
    Myfiles.close();

/*To read from a file, use either the "ifstream" or "fstream" class, and the name of the file.
Note that we also use a while loop together with the getline() function (which belongs to the ifstream class) to read the file line by line, and to print the content of the file:*/

    // Create a text string, which is used to output the text file
    string myText;

    // Read from the text file
    ifstream MyReadFile("filename.txt");

    // Use a while loop together with the getline() function to read the file line by line
    while (getline (MyReadFile, myText)) {
    // Output the text from the file
    cout << myText;
    }

    // Close the file
    MyReadFile.close();
}