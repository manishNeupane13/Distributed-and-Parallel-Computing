#include<omp.h>
#include<stdio.h>
#include<stdlib.h>
#define parent_tid 0
int main()
{
    int tid;
    // printf("hello i have edited in vim ");
    #pragma omp parallel
    {
     tid=omp_get_thread_num();
     if (tid==parent_tid)
     {
  printf("Parent : %d  Thread running \n",omp_get_thread_num());

     }
     else{
         printf("Threads # %d : running \n", tid);
     }
    }
    return EXIT_SUCCESS;
}
