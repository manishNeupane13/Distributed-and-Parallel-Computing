#include<iostream>
#include<thread>
#include<mutex>
using namespace std;
std:: mutex mu;


void shared_print(string msg,int result)
{
    mu.lock();
    cout<<msg<<result<<endl;
    mu.unlock();
}
void sum(int a,int b)
{
    shared_print(string ("The addition of two number = "),a+b);
}
    
void subtract(int a, int b)
{
    shared_print(string("The suntraction of two number = "), a - b);

   

}
void multiply(int a, int b)
{
    shared_print(string("The multiplication of two number = "), a * b);

    
}
void division(int a,int b)
{
    shared_print(string("The division of two number = "), a / b);
}
int main()
{
int a=9;
int b=3;
// sum(a,b);
// subtract(a,b);
// multiply(a,b);
// division(a,b);

thread t1(sum,a, b);
thread t2(subtract,a, b);
thread t3(multiply,a,b);
thread t4(division,a,b);

// thread t1(sum(a,b));
// thread t2(subtract(a,b));
// thread t3(multiply(a,b));
// thread t4(division(a,b));

t1.join();
t2.join();
t3.join();
t4.join();
return 0;



}