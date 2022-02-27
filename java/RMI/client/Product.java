import java.rmi.*;

public interface Product extends Remote {
// define behavoior or methods
    public String getName() throws RemoteException;

    public String getDescription() throws RemoteException;

    public Double price() throws RemoteException;

}
