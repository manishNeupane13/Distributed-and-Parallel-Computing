#include<stdio.h>
#include <omp.h>
unsigned long long int final_result;
void primenumber(unsigned long long int num)
{
    unsigned long long int i = 0;
    int count = 0;

    #pragma omp sections
    {
        for (i = 1; i <= num; i++)
    {
            if (num % i == 0)
            {
                count++;
                if (count >2)
                {
                    break;
                }
            }
        }
    }
    if (count <= 2)
    {
        printf("%lu ",num);
    final_result += num;

    }
    
}

void add(unsigned long long int start,unsigned long long int end)
{
    unsigned long long int i;
    unsigned long long int sum=0;
    for (i =start; i<end;i++)
    {
        if (i %2 !=0 || i ==2)
        {
            primenumber(i);
        }
    }
    

}




int main()
{

  unsigned long long int n=1000000;
omp_set_num_threads(4);


#pragma openmp sections
    {
        add(1, (unsigned long long int)(n / 4));
        add((unsigned long long int)(n / 4), (unsigned long long int)(2 * n / 4));

        add((unsigned long long int)(2 * n / 4), (unsigned long long int)(3 * n / 4));

        add((unsigned long long int)(3 * n / 4), (unsigned long long int)(n + 1));
    }





printf("The total sum of %lu number = %lu\n", n, final_result-1);
}