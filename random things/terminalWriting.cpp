#include<iostream>
#include<string>
#include<cstdlib>

#ifdef _WIN32 // Check if the code is being compiled on Windows
#define CLEAR_SCREEN "cls"
#elif __linux__ // Check if the code is being compiled on a Linux system
#define CLEAR_SCREEN "clear"
#endif


void delay(int n) {
    for (unsigned long long int i = 0; i < n*99999999; i++);
}


using namespace std;

int main() {
    int delayTime = 1;
    bool linuxOnly = false;
    cout << "Enter String : ";
    string str;
    getline(cin,str);
    system(CLEAR_SCREEN);
    delay(10);

    if (CLEAR_SCREEN == "clear") {
        delayTime = 2;
        linuxOnly = true;
    }
    
    for (int i = 0; i < str.length(); i++) {
        for (int j = 0; j <= i; j++) {
            if(str[j] == '.' && str[j+1] == '.') {
                cout << endl;
                j++;
                continue;
            }
                cout << str[j];
        }
        if (linuxOnly) {
            cout << endl;
        }

        if (str[i+1] == ' ' || str[i+1] == ',' || str[i+1] == '.' || str[i+1] == '?' || str[i+1] == '!') {
            delay(delayTime+1);
        }
        delay(delayTime);
        if (i < str.length()-1){
            system(CLEAR_SCREEN);
        }
    }
    cout << endl;
}   
