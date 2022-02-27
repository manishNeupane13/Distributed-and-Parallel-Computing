import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

;

public class Client

{
    public static void main(String[] args) {

        // Access the objects from the server JVM using namelookup methodss provided by
        // RMI
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
            Product laptop = (Product) registry.lookup("laptop");
            Product laptop1 = (Product) registry.lookup("mobile");
            String responses1 = laptop.getDescription();
            String responses2 = laptop.getName();
            System.out.println("Resopnse description : " + responses1);
            System.out.println(" name = " + responses2);

            String response = laptop1.getDescription();
            String response2 = laptop1.getName();

            System.out.println("Resopnse description : " + response);
            System.out.println(" name = " + response2);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Client Exception : " + e.toString());
            e.printStackTrace();
        }

    }
}