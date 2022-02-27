import java.io.*;
import java.net.*;


public class TcpServer
{

 
    public static void main(String[] argv) throws Exception
    {
        //to store the data received from the clients
        String clientsentence;
        //to store processed data by the servers ,that need to be sent to the client
        String capitalizedsentence;

//create a server socket using socket class thtat opens the port 6789
        ServerSocket welcomeSocket = new ServerSocket(3000);
        // create a while loop which continously listen to client
        while(true)
        {
           //create connectio socket
            Socket ConnectionSocket=welcomeSocket.accept();

        // retrive the data from the connectionSocket  sent by her the client using InputStream and save it to the BufferReader
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(ConnectionSocket.getInputStream()));
        //retrive the data from the buffer reader and store the clientsentence variable. use readline
        clientsentence=inFromClient.readLine();

        //calculating the power portion
        //changing string form of input form user to number 
        int number =Integer.parseInt(clientsentence);
        //formula to calcutate the po
        double result=Math.pow(number, 2);

        
        // now convert the recevied clieny data to uppercase
        //this is the processing 
        capitalizedsentence="The power of "+number+" = " +result+"\n";
        //now time to resend the processed data to the client
        // create data outputstream and send the data to the client using same connnectionsocket variable 
        DataOutput outToClient=new DataOutputStream(ConnectionSocket.getOutputStream());
        
        // write data to the output stream

        outToClient.writeBytes(capitalizedsentence);

        }
 
        
    }
}