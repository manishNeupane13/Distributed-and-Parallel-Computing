public class demo {
    public static void main(String[] args) {
        int a=2;
        int b=7;
        int c=5;
        double value = Math.pow(b, 2) - 4 * a * c;
        System.out.println("value = " + value);
        System.out.println(Math.sqrt(value));

        double root1 = ((-b + Math.sqrt(value)) / (2 * a));
        double root2 =( (-b - Math.sqrt(value)) / (2 * a));
        String result = "The first root = " + root1 + "\nThe second root = " + root2;
        System.out.println(result);

    }  
}
