import java.rmi.*;

public class Productimpl implements Product{
    String name;
    String description;
    double price;
Productimpl(String newName, String newDescription,double price) throws RemoteException
 {
    super(); //called by default
    this.name=newName;
    this.description=newDescription;
    this.price=price;

    }

    @Override
    public String getName() throws RemoteException {
        // TODO Auto-generated method stub
        return this.name;
    }

    @Override
    public String getDescription() throws RemoteException{
        // TODO Auto-generated method stub
        return this.description;
    }

    @Override
    public Double price() throws RemoteException {
        // TODO Auto-generated method stub
        return this.price();
    }
    
}
