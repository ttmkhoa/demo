// File Name GreetingClient.java
import java.net.*;
import java.io.*;

public class GreetingClient {

   public static void main(final String[] args) {
       final String serverName = args[0];
       final int port = Integer.parseInt(args[1]);
       try {
           System.out.println("Connecting to " + serverName + " on port " + port);
           final Socket client = new Socket(serverName, port);

           System.out.println("Just connected to " + client.getRemoteSocketAddress());
           final OutputStream outToServer = client.getOutputStream();
           final DataOutputStream out = new DataOutputStream(outToServer);

           out.writeUTF("Hello from " + client.getLocalSocketAddress());
           final InputStream inFromServer = client.getInputStream();
           final DataInputStream in = new DataInputStream(inFromServer);

           System.out.println("Server says " + in.readUTF());
           client.close();
       } catch (final IOException e) {
         e.printStackTrace();
      }
   }
}