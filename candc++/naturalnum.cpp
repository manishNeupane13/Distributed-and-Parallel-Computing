#include<iostream>
#include<thread>
#include<mutex>
using namespace std;
unsigned long long int final_result = 0;

std::mutex mu;
void shared_paired(string msg, double result)
{
    mu.lock();
    cout << msg << result << endl;
    mu.unlock();
}

void f1(unsigned long long int n)
{

    unsigned long long int i;
    unsigned long long int sum = 0;
    for (i=1;i<n/4;i++)
    {
        sum +=i;
    }
    shared_paired(string("number1 ="), sum);
   
    final_result +=sum;
    
}
void f2(unsigned long long int n)
{

    unsigned long long int i;
    unsigned long long int sum = 0;
    for (i = (n/4); i < (2*n / 4); i++)
    {
        sum += i;
    }
    shared_paired(string("number2 ="), sum);
   
    final_result += sum;
   
}
void f3(unsigned long long int n)
{
    unsigned long long int i;
    unsigned long long int sum = 0;
    for (i = (2*n / 4); i <(3 * n / 4); i++)
    {
        sum += i;
    }
    shared_paired(string("number3 ="), sum);
    
    final_result += sum;
    
}
void f4(unsigned long long int n)
{
    unsigned long long int i;
    unsigned long long int sum = 0;
    for (i = (3*n / 4); i <=n; i++)
    {
        sum += i;
    
    }
    shared_paired(string("number4 ="), sum);
    
    final_result += sum;
  
}

int main()
{

    unsigned long long int num = 100000000;

    // thread t1(f1,num);
    // thread t2(f2,num);
    // thread t3(f3,num);
    // thread t4(f4,num);
    // t1.join();
    // t2.join();
    // t3.join();
    // t4.join();

    // f1(num);
    // f2(num);
    // f3(num);
    // f4(num);
//    // double
//  double resutl_final = (result_sum1 + result_sum2 + result_sum3 + result_sum4);

    // cout << "The total sum of 1 billion numbers ="<<resutl_final<< endl;
    cout << "The total sum of 1 billion numbers =" << final_result << endl;

}