#include<iostream>
#include<omp.h>
#include <thread>
unsigned long long int final_result=0;


 void addfunction(unsigned long long int start ,unsigned long long end)
 {
     unsigned long long int i;
    //  unsigned long long int sum=0;
     
     for (i=start;i<end;i++)
     {
        // sum+=i;
        final_result +=i;
    }
    //   count++;
    
    //   cout<<"The sum of "<<count<<" quarter ="<<sum<<endl;
 }

int main()
{
unsigned long long int num=10000000000;

thread t1(addfunction, 1, (num / 4));
t1.join();
thread t2(addfunction, (num / 4), (2 * num / 4));
t2.join();
thread t3(addfunction, (2 * num / 4), (3 * num / 4));
t3.join();
thread t4(addfunction, (3 * num / 4), num + 1);
t4.join();
cout<<"The sum of the 10 billion of numbers = "<<final_result<<endl;



}
