#include <iostream>
#include <string>
#include<cstdlib>

#ifdef _WIN32 // Check if the code is being compiled on Windows
#define CLEAR_SCREEN "cls"
#elif __linux__ // Check if the code is being compiled on a Linux system
#define CLEAR_SCREEN "clear"
#endif

using namespace std;

void delay(int n) {
    for (unsigned long long int i = 0; i < n*99999999; i++);
}

int main() {
    cout << "Enter String: ";
    string str;
    getline(cin, str);
    system(CLEAR_SCREEN);
    delay(10);

    for (int i = 0; i < str.length(); i++) {
        if(str[i] == '.' && str[i+1] == '.') {
                cout << endl;
                i++;
                continue;
        }

        cout << str[i];
        
        cout.flush();
        
        if (str[i+1] == ' ' || str[i+1] == ',' || str[i+1] == '.' || str[i+1] == '?' || str[i+1] == '!') {
            delay(2);
        }
        
        delay(1);
    }

    cout << endl;
}
