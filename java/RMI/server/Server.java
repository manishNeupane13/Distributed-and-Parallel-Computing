import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;

public class Server

{
    public static void main(String[] args) {

        // we creater the objects from productimpl class
        // wrap insdie RMI SECURITY MANAGER
        // register object to RMI manager
        // start the RMI Server
        // listen to the particular port for client request
        try {

            System.out.println("Server is booting now. ");
            System.out.println("create product object. ");
            // create an object of productimpl and it it accessed by client
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            Productimpl ob1 = new Productimpl("laptop", "I7 10 generations with 1TB SSD", 1150);
            Productimpl ob2 = new Productimpl("moblie", "M1 Processor with 500 SSD", 1350);
            //

            // export

            Product stub = (Product) UnicastRemoteObject.exportObject(ob1, 0);
            Product stub2 = (Product) UnicastRemoteObject.exportObject(ob2, 0);
            // bind the remore object's stub in the registry

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
            registry.rebind("laptop", stub);
            registry.rebind("mobile", stub2);
            System.err.println("server ready");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("some server error occured " + e);
        }

    }
}
