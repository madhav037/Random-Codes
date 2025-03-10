#stack
class Stack:
    __arr = []
    __top = -1
    
    def __init__(self):
        self.__top = -1
    
    def push(self,element):
        self.__arr.append(element)
        self.__top += 1
        return
    
    def display(self):
        for i in self.__arr:
            print(i)
        return
    
    def pop(self):
        self.__top -= 1
        return self.__arr.pop()
    
    def peep(self,index):
        if self.__top - index + 1 > self.__top:
            print("Invalid index")
            return
        return self.__arr[self.__top - index + 1]

    def change(self,index,element):
        if self.__top - index + 1 > self.__top:
            print("Invalid index")
            return
        self.__arr[self.__top - index + 1] = element
        return

st = Stack()
st.push(45)
st.push(46)
st.push(46)
st.push(46)
st.push("Hello")
st.display()
st.pop()
st.pop()
st.display()
st.peep(2)
st.change(2,"Hi")
st.display()
