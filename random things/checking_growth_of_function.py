from cmath import log


for i in [5, 50, 500, 5000, 50000] :
    print("for ",i, "max val is ")
    print(log(log(i)), log(i), pow(i,0.5), pow(log(i),2), i, i*log(i), pow(i,2), pow(i,2)+log(i), sep='\n') 
    print()