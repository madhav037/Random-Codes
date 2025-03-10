import random as r
movieList = ['your name', 'tenki no ko', 'jab we met', 'avengers endgame', 'spiderman homecomming', 'spiderman no way home']

guessMovie = r.choice(movieList)

numOfHints = r.randint(1,len(guessMovie)//2)

showHint = r.choice([True,False])

hintText = ''

for i in range(len(guessMovie)):
    if showHint and numOfHints > 0:
        hintText += guessMovie[i]
        numOfHints -= 1
    else:
        hintText += '_'       
    showHint = r.choice([True,False])

while True:
    print(hintText)
    char = input("Enter a guess letter : ")
    if guessMovie.find(char) != -1:
        for i in range(len(guessMovie)):
            if guessMovie[i] == char:
                temp = hintText[:i:]
                temp2 = hintText[i+1::]
                hintText = temp + guessMovie[i] + temp2
    else:
        print("incorrect guess")
    
    if hintText == guessMovie:
        print("you won!")
        break