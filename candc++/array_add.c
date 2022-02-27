#include<stdio.h>
#include<omp.h>
int main()
{
    long long i ,k,n =100000;
    long long a;
    long long b=134;
    long long c=187;
    printf("edit in vim is allowded");
   
   
// #pragma omp parallel  for
    for (i=0;i<n;i++)

    {
        b=i*2;//value initilizing
        c=i*3;
        k=i;
        a=b+k*c;
        printf("\nThe value of array A =%ld ",a);
    }
    
 


}
