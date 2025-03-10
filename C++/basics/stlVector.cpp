#include<iostream>
#include<vector>
// it is basically a dynamic array 
//when the size is full and you want to add new element it copies the array then deletes the old array and 
//makes a new array with old values with double size than previous one
using namespace std;

int main() {

    vector<int> v;

    cout<<"Size : " << v.size() << endl; // shows how many elements are there
    cout<<"Capacity : " << v.capacity() << endl; // how mucn space is assigned

    v.push_back(1); // it add element from back into vector
    cout<<"Size : " << v.size() << endl;
    cout<<"Capacity : " << v.capacity() << endl;

    v.push_back(2);
    v.push_back(3);
    cout<<"Size : " << v.size() << endl;
    cout<<"Capacity : " << v.capacity() << endl;

    v.push_back(4);
    v.push_back(5);
    v.push_back(6);
    cout<<"Size : " << v.size() << endl;
    cout<<"Capacity : " << v.capacity() << endl;


    cout<<"3rd index : " << v.at(3) << endl; // same as array
    cout<<"First element : "<< v.front() << endl;
    cout<<"Last element : "<< v.back() << endl;

//for each loop : used exclusively to loop through elements in an array (Syntax : for(dataType Variablename :arrayName){})
    cout<<"Before pop : "<<endl;
    for (int i : v){ 
        cout<<i <<" ";
    }
    cout<<endl;

    v.pop_back(); // removes the last element

    cout<<"After pop : "<<endl;
    for (int i : v){ 
        cout<<i <<" ";
    }
    cout<<endl;

    cout<<"Size before clear : " <<v.size() <<endl;
    v.clear();          // it clear the elements of the vector 
    // NOTE : only elements are removed it still takes up space it just empties the array
    // capacity is still there
    cout<<"Size After clear : " <<v.size() <<endl;





    vector<int> v1(5,1); //here 5 is the size of vector and we initialize every element with 1
    cout<<"v1 vector"<<endl;
    for (int i : v1){ 
        cout<<i <<" ";
    }
    cout<<endl;


    vector<int> copy(v1); // by this we can copy whole one vector to another here "v1" is copied to "copy"
    cout<<"copied vector"<<endl;
    for (int i : copy){ 
        cout<<i <<" ";
    }
    cout<<endl;

}