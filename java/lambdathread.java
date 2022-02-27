
class threadimplements {
    double runthread(double start, double end) {
        double sum = 0;
        for (double i = start; i < end; i++) {

            sum += i;

        }
        System.out.println("The  sum in "+Thread.currentThread().getName()+ "=" + + sum);
        return sum;

    }
}

public class lambdathread {
    public static void main(String[] args) {

        double n = 1000000000;
        double[] final_result = new double[4];
        
        Thread t1 = new Thread(() -> {
            final_result[0] += new threadimplements().runthread(1, n / 4);
        }

        );
        Thread t2 = new Thread(() -> {
            final_result[1] += new threadimplements().runthread(n/4, 2*n / 4);
        }

        );
        Thread t3 = new Thread(() -> {
            final_result[2] += new threadimplements().runthread(2*n/4, 3*n / 4);
        }

        );
        Thread t4= new Thread(() -> {
            final_result[3] += new threadimplements().runthread(3*n/4, n +1);
        }

        );
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            {
                t1.join();
                t2.join();
                t3.join();
                t4.join();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("The sum of all the given natural number = "+(final_result[0]+final_result[1]+final_result[2]+final_result[3]));

    }

}
