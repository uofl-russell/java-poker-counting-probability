#include <iostream>
#include <string>
using namespace std;

int factorial(int n) {
    if (n==0 || n==1) {
        return 1;
    }
    return n*factorial(n-1);
}

int choose(int n,int k) {
    if (k<n) { return 0; }
    return (factorial(n))/(factorial(k)*factorial(n-k));
}

int main(int argc, char* argv[]){
  int n = atoi(argv[1]);
  int k = atoi(argv[2]);
  cout<<choose(n,k)<<endl;
}

