#include <iostream>
#include <thread>
using namespace std;

void evenSum()
{
    long sum = 0;
    int i;

    for (i = 0; i <=1000000; i++)
    {
        if (i % 2 == 0)
            sum += i;
    }
    cout << "The sum of even Number =" << sum << endl;
}

void oddSum()
{
    long sumodd = 0;
    int i;

    for (i = 0; i <= 1000000; i++)
    {
        if (i % 2 != 0)
            sumodd += i;
    }
    cout << "The sum of odd Number = " << sumodd << endl;
}
int main()
{

    thread t1(evenSum);
    t1.join();
    thread t2(oddSum);
    t2.join();
}
