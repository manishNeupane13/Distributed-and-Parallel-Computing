public class threads{

    double final_result;
    public void run(double start ,double end)
    {
         double sum = 0;
    
        for (double i =start ;i<end;i++)
        {
           
            sum +=i;
        
          
        }
        final_result+=sum;
        System.out.println("the sum of natural number =,"+sum);
    

    }
    public static void main(String[] args) {
        double n=1000000000;
        threads ob=new threads();
        ob.run(1,n/4);
        ob.run((n / 4), (2 * n / 4));
        ob.run((2*n/4),(3*n/4));
        ob.run((3*n/4),(n+1));
        System.out.println("The final sum ="+ob.final_result);
        threads obj1=new threads();
        obj1.run(1.0, 1000000001.0);
       
    

        
    }
    
}
