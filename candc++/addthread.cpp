#include <iostream>
#include <thread>
#include <mutex>
using namespace std;

unsigned long long int final_sum = 0;

void primenumber(unsigned long long int num)
{
    unsigned long long int i = 0;
    int count = 0;
#pragma omp for reduction
    {
        for (i = 2; i <= num / 2; i++)
        {
            if (num % i == 0)
            {
                count++;
            }
        }
        if (count <= 2)
        {
            final_sum += num;
        }
    }
}

void add(unsigned long long int start, unsigned long long int end)
{
    unsigned long long int i, sum = 0;

    for (i = start; i < end; i++)
    {
        primenumber(i);
    }
}

int main()
{
    unsigned long long int n = 10;
    if (n % 2 == 0)
    {
#pragma openmp sections
        {
            add(1, (unsigned long long int)(n / 4));

            add((unsigned long long int)(n / 4), (unsigned long long int)(2 * n / 4));

            add((unsigned long long int)(2 * n / 4), (unsigned long long int)(3 * n / 4));

            add((unsigned long long int)(3 * n / 4), (unsigned long long int)(n + 1));
        }
    }

    cout << "The total sum of " << n << " of number =" << final_sum << endl;
    // unsigned long long int grand;
    // grand=sum1+sum2+sum3+sum4;
    // cout << "The total grand sum of 10 billion of number =" <<grand<< endl;
}
