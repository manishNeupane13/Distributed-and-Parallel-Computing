#include<stdio.h>
#include<omp.h>
#include<stdlib.h>
long long final_result=0;

void evensum(long num)
{
 int i;
 for(i=0;i<=num;i++)
 {
     if (i%2==0)
     {
         final_result+=i;
     }
 }
 printf("The sum of the even  number %i\n", final_result);
}
void oddsum(long num)
{

    int i;
    long long sum;
    for (i =1; i <= num; i++)
    {
        if (i % 2 != 0)
        {
            final_result += i;
            sum+=i;
        }
    }
    printf("The sum of the odd number %i\n",sum);
}

 int main()
 {

     long long num=20000;
     omp_set_num_threads(8);
     #pragma openmp sections 
     {
         #pragma openmp sections
         evensum(num); 
        
         #pragma openmp sections
         oddsum(num);
         
     }
     printf("The sum of the even and odd number %i\n" ,final_result);
 }