import java.util.Scanner;

public class calulatorthread {

    void add(int num1,int num2)
    {
    System.out.println("The sum of "+num1+" and "+num2+" = "+(num1+num2));
    }
    void subtract(int num1,int num2)
    {
        System.out.println("The subtraction of " + num1 + " and " + num2 + " = " + (num1 - num2));
    }
    void multiply(int num1,int num2)
    {
        System.out.println("The multiplication of " + num1 + " and " + num2 + " = " + (num1 * num2));
    }
    void division(int num1,int num2)
    {
        System.out.println("The division of " + num1 + " and " + num2 + " = " + (double)(num1 /(double)num2));
    }
    void modulus(int num1,int num2)
    {
        System.out.println("The modulus of " + num1 + " and " + num2 + " = " + (num1 % num2));
    }
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
    System.out.println("Enter the first natural number : ");
    int num1=sc.nextInt();
    System.out.println("Enter the second  natural number : ");
    int num2 = sc.nextInt();
    calulatorthread obj=new calulatorthread();
    



        Thread t1= new Thread( ()->
        {
         obj.add(num1,num2);
        }
        );
        Thread t2 = new Thread(() -> {
            obj.subtract(num1, num2);
        });
        Thread t3 = new Thread(() -> {
            obj.multiply(num1, num2);
        });
        Thread t4 = new Thread(() -> {
            obj.division(num1, num2);
        });
        Thread t5 = new Thread(() -> {
            obj.modulus(num1, num2);
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
