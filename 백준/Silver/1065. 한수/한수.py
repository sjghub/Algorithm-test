def solve(t):
    b=[]
    for k in range(1,t+1):
        nstr = str(k)
        if len(nstr) == 1 or len(nstr) == 2:
            b.append(k)
        elif len(nstr)==3:
            if (int(nstr[0]) - int(nstr[1])) == (int(nstr[1]) - int(nstr[2])):
                b.append(k)
    return print(len(b))


t = int(input())

solve(t)
