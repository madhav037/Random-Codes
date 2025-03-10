#include<iostream>
#include<array> // must include array library to use it

using namespace std;

int main(){

    int basic_array[3] = {1,2,3}; // it is a basic array which we use daily

    array<int,4> a = {1,2,3,4}; // it is a STATIC array (Syntax : array< datatype , length > name) using stl

    int size = a.size(); // it gives size of array

    for (int i = 0; i < a.size(); i++)
    {
        cout<<a[i] << endl;
    }
    
    cout<<"Element at 2nd index : " << a.at(2)<<endl; //it is used to get value at particular index (it is used more as if index is out of bounds then it gives error instead of garbage value)

    cout<<"Check if array is empty or not : "<< a.empty()<<endl;//returns a boolean 

    cout<<"First element : " << a.front() << endl; // gets the first element
    cout<<"Last element : " << a.back() << endl; //gets the last element 

}