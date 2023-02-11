from collections import OrderedDict
import sys
import math


def get_parameter_vectors():
    '''
    This function parses e.txt and s.txt to get the  26-dimensional multinomial
    parameter vector (characters probabilities of English and Spanish) as
    descibed in section 1.2 of the writeup

    Returns: tuple of vectors e and s
    '''
    #Implementing vectors e,s as lists (arrays) of length 26
    #with p[0] being the probability of 'A' and so on
    e=[0]*26
    s=[0]*26

    with open('e.txt', encoding = 'utf-8') as f:
        for line in f:
            #strip: removes the newline character
            #split: split the string on space character
            char,prob=line.strip().split(" ")
            #ord('E') gives the ASCII (integer) value of character 'E'
            #we then subtract it from 'A' to give array index
            #This way 'A' gets index 0 and 'Z' gets index 25.
            e[ord(char)-ord('A')]=float(prob)
    f.close()

    with open('s.txt', encoding = 'utf-8') as f:
        for line in f:
            char,prob=line.strip().split(" ")
            s[ord(char)-ord('A')]=float(prob)
    f.close()

    return (e,s)

def shred(filename):
    #Using a dictionary here. You may change this to any data structure of
    #your choice such as lists (X=[]) etc. for the assignment
    X=OrderedDict()
    with open(filename, encoding = 'utf-8') as f:

        contents = f.read()
        a = contents.count("A") + contents.count("a")
        b = contents.count("B") + contents.count("b")
        c = contents.count("C") + contents.count("c")
        d = contents.count("D") + contents.count("d")
        e = contents.count("E") + contents.count("e")
        f = contents.count("F") + contents.count("f")
        g = contents.count("G") + contents.count("g")
        h = contents.count("H") + contents.count("h")
        i = contents.count("I") + contents.count("i")
        j = contents.count("J") + contents.count("j")
        k = contents.count("K") + contents.count("k")
        l = contents.count("L") + contents.count("l")
        m = contents.count("M") + contents.count("m")
        n = contents.count("N") + contents.count("n")
        o = contents.count("O") + contents.count("o")
        p = contents.count("P") + contents.count("p")
        q = contents.count("Q") + contents.count("q")
        r = contents.count("R") + contents.count("r")
        s = contents.count("S") + contents.count("s")
        t = contents.count("T") + contents.count("t")
        u = contents.count("U") + contents.count("u")
        v = contents.count("V") + contents.count("v")
        w = contents.count("W") + contents.count("w")
        x = contents.count("X") + contents.count("x")
        y = contents.count("Y") + contents.count("y")
        z = contents.count("Z") + contents.count("z")

        X["A"] = a
        X["B"] = b
        X["C"] = c
        X["D"] = d
        X["E"] = e
        X["F"] = f
        X["G"] = g
        X["H"] = h
        X["I"] = i
        X["J"] = j
        X["K"] = k
        X["L"] = l
        X["M"] = m
        X["N"] = n
        X["O"] = o
        X["P"] = p
        X["Q"] = q
        X["R"] = r
        X["S"] = s
        X["T"] = t
        X["U"] = u
        X["V"] = v
        X["W"] = w
        X["X"] = x
        X["Y"] = y
        X["Z"] = z

    return X

print("Q1")
shred_obj = shred("letter.txt")
for letter, occurrences in (shred_obj).items():
    print(letter + " " + str(occurrences))

print("Q2")

vals = get_parameter_vectors()
s1 = vals[1][0]
e1 = vals[0][0]
X1 = float(shred_obj["A"])
prob_s = round((X1*math.log(s1)),4)
prob_e = round((X1*math.log(e1)),4)
print(prob_e)
print(prob_s)

print("Q3")

initial_e_log = math.log(0.6)
initial_s_log = math.log(0.4)
i = 0

last_part_e = 0
last_part_s = 0

for key in shred_obj:
    last_part_e = last_part_e + float(shred_obj[key])*((math.log(vals[0][i])))
    last_part_s = last_part_s + float(shred_obj[key])*((math.log(vals[1][i])))
    i = i +1

final_e_Q3 = math.log(0.6) + last_part_e
print('%.4f' %final_e_Q3)

final_s_Q3 = math.log(0.4) + last_part_s
print('%.4f' %final_s_Q3)

print("Q4")

q4_checker = final_s_Q3 - final_e_Q3

if q4_checker >= 100:
    print("0.0000")
elif q4_checker <= -100:
    print("1.0000")
else:
    final_e_Q4 = (1 / (1+math.exp(q4_checker)))
    #rounded = round(final_e_Q4,4)
    print('%.4f' % final_e_Q4)


