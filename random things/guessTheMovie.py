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

    gotName = input("guess movie : ")
    gotName = gotName.lower()
    if len(gotName) != len(guessMovie):
        print("invalid length")
    else: 
        for i in range(len(gotName)):
            if gotName[i] == guessMovie[i]:
                temp = hintText[:i:]
                temp2 = hintText[i+1::]
                hintText = temp + guessMovie[i] + temp2
        
        if gotName == guessMovie:
            print("you won")
            break