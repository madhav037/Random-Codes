import random

count = 0
rangeBegin = int(input("enter range Begin : "))
rangeEnd = int(input("enter range End : "))
prevInput = rangeBegin

num = random.randrange(rangeBegin, rangeEnd)
print("For hint press h")

while True :
    guessedNum = input(f"Guess The Number bet {rangeBegin}-{rangeEnd}: ")
    if guessedNum != 'h':
        prevInput = int(guessedNum)
        if num == int(guessedNum) :
            print("You Guessed Correct number!!")
            break
        else :
            print("Try again!")
    elif guessedNum == 'h' :
         if num - prevInput < 0:
             print(f"Number is smaller than {prevInput}")
         elif num - prevInput > 0:
             print(f"Number is greater than {prevInput}")

    
    
    