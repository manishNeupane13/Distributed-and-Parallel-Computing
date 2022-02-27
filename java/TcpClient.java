import java.io.*;
import java.net.*;

public class TcpClient

{
    public static void main(String[] argv)  throws Exception{
        
        String sentence;
        String modifiedsentence; // to hold the data received from sever
        int number;

        String serverAddress="127.0.0.1";
        Integer serverPort=3000;

        // read a stream of data from keyboard using Buffereader and inputstreamReader

        BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
        
        //create a client socket to connect with server.

        Socket clientSocket=new Socket(serverAddress, serverPort);

         // prepare the data outputstream to send the data through the created clientSocket.

         DataOutputStream outToServer=new DataOutputStream(clientSocket.getOutputStream());
        
        //send data to the server for processing
        System.out.println("Enter the number which power to be raised :");
        
         sentence=inFromUser.readLine();
         
         outToServer.writeBytes(sentence+"\n");




         //********************* */
         //data receving part
         //create the input stream reader to read the data from the server 
        
         
         BufferedReader inFromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
          

         //transfer data from buffer to the variable 
        modifiedsentence=inFromServer.readLine();
        //showing in terminal
        System.out.println("From the server : "+modifiedsentence);
        //socket close
        clientSocket.close();



    }
}
