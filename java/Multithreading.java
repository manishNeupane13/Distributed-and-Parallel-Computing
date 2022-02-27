class Firstthread implements Runnable 
{
    double start;
    double end;
    double final_result;

    Firstthread(double start,double end)
    {
     this.start=start;
     this.end=end;

    }

public  void run()
{
    double sum=0;
    for(double i=this.start;i<this.end;i++)
    { 
   
      sum +=i;
    }
        this.final_result +=sum ;
        System.out.println("sum of quarter = "+sum);
}

}
class Secondthread implements Runnable 
{

public  void run()
{
    for(int i=0;i<4;i++)
    {
        System.out.println("Second ruuning thread");
    }
}

}

public class Multithreading {
    public static void main(String[] args) {
        double n=100;
        
   Thread t1= new Thread(new Firstthread(1,n/4));
   Thread t2=new Thread(new Firstthread(n/4,2*n/4));
   Thread t3=new Thread(new Firstthread(2*n/4,3*n/4));
   Thread t4=new Thread(new Firstthread(3*n/4,n+1));
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



   System.out.println("The sum of 1 billion natural number = "+new Firstthread(0.0,0.0).final_result);
 

    
    }
}