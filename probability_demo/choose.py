import sys 

def factorial(n):
    if n<1:
        return 1
    return n*factorial(n-1)

def choose(n,k):
    if k<n:
        return 0
    return factorial(n)//(factorial(k)*factorial(n-k))

n = int(sys.argv[1])
k = int(sys.argv[2])

print(str(choose(n,k)))