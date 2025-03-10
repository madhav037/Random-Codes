toDOdata = ["Hello", "How", "Do", "You", "Do"]
toDOdataCompleted = []
runLoop = True

def getdetails() : 
    print("Enter 1 - show all tasks")
    print("Enter 2 - add task")
    print("Enter 3 - delete task")
    print("Enter 4 - edit task")
    print("Enter 5 - Show completed")
    print("Enter Tasks's number and 'c' to mark completed")
    input = input("Enter input : ")
    return input

def showAll() :
    print("\n")
    for index, data in enumerate(toDOdata):
        print(f"{index + 1} : {data}")
    print("\n")
    main()

def add() :
    print("\n")
    toDOdata.append(input("Enter You To-Do - "))
    showAll()

def delete() :
    print("\n")
    for index, data in enumerate(toDOdata):
        print(f"{index + 1} : {data}")
    index = int(input("Enter number of the to-do : "))
    toDOdata.pop(index-1)
    showAll()

def edit() :
    print("\n")
    for index, data in enumerate(toDOdata):
        print(f"{index + 1} : {data}")
    index = int(input("Enter number of the to-do : "))
    toDOdata[index-1] = input("Enter edited value : ")
    showAll()

def showCompleted() :
    print("\n")
    for index, data in enumerate(toDOdataCompleted):
        print(f"{index + 1} : {data}")
    print("\n")
    main()

def main() : 
    while True:
        print("|| To mark as complete press c-number ||")
        print("Enter 1 - show all tasks")
        print("Enter 2 - add task")
        print("Enter 3 - delete task")
        print("Enter 4 - edit task")
        print("Enter 5 - Show completed")
        print("Enter 6 - End")
        
        inputValue = input("Enter input : ")
        if inputValue.startswith('c-'):
            task_number = inputValue[2:]
            task_number = int(task_number)
            if task_number >= 1 and task_number <= len(toDOdata) :
                toDOdataCompleted.append(toDOdata[task_number-1])
                toDOdata.pop(task_number-1)
                showAll()
            else :
                print("Not valid input")
                main()
        else :    
            match inputValue:
                case '1':
                    showAll()
                    break
                case '2':
                    add()
                    break
                case '3':
                    delete()
                    break
                case '4':
                    edit()
                    break
                case '5':
                    showCompleted()
                    break
                case '6':
                    runLoop = False
                    break;
                case _:
                    print("Enter valid value")
    

main()
#show all
#add
#delete
#edit
#mark completed
#show completed

    