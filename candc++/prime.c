#include <stdio.h>
#include <omp.h>
#include<math.h>

#define END 100000000

// Only pass odd values to this function
int is_prime(unsigned long long int v)
{
    unsigned long long int end = sqrt(v);
    for (unsigned long long int i = 3; i <= end; i += 2)
    {
        if ((v % i) == 0)
        {
            return 0;
        }
    }
    return 1;
}

int main(int argc, char **argv)
{
    // We'll grab 2 as it's the only even prime
    int prime_count = 1;

    unsigned long long int bracket = 10;

#pragma omp parallel for num_threads(4)
    for (unsigned long long int i = 3; i < END; i += 2)
    {
        if (i > bracket)
        {
            printf("%lu\t%lu\n", bracket, prime_count);
            bracket *= 10;
        }
        if (is_prime(i))
        {
            prime_count++;
        }
    }
    printf("%lu\t%lu\n", bracket, prime_count);
    return 0;
}