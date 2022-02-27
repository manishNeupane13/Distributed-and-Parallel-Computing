#include<iostream>
#include<thread>
#include<mutex>
using namespace std;

long long even_Sum;
long long odd_Sum;

std::mutex mu;
void shared_paired(string msg, double result)
{
    mu.lock();
    cout << msg << result << endl;
    mu.unlock();
}

void evenSum(long long num)
{
    int i=0;
    double  sum =0;

for (i=1;i<=num;i++)
{
    if (i%2==0)
        sum +=i;
}
   even_Sum=sum;
    shared_paired(string("The sum of even number ="), sum);
}

void oddSum(long long num)

{
    int i = 0;
    double sum = 0;

    for (i = 1; i <=num; i++)
    {
        if(i%2!=0)
            sum += i;
    }
    odd_Sum=sum;
    shared_paired(string("The odd of even number ="), sum);
}

int main()
{

    long long num=100000000;
   
    thread t1(evenSum,num);
    thread t2 (oddSum,num);

    t1.join();
    t2.join();
    
    cout<<"The result of even and odd sum = "<<(even_Sum+odd_Sum)<<endl;
}
