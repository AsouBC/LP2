import random
def soma(n1, n2):
    return n1 + n2

x1 = random.randint(1,10)
x2 = random.randint(1,10)

print(soma(x1, x2))

if(soma(x1, x2) > 10 and soma(x1, x2) != 15 and soma(x1, x2) != 20):
    print('Igor eh gay')
elif(soma(x1, x2) <= 10):
    print('Pedro eh gay')
elif(soma(x1, x2) == 15):
    print('Grande Samukinha eh gay')
elif(soma(x1, x2) == 20):
    print('Caioba eh gay')