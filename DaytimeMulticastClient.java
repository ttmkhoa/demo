import java.net.*;
import java.io.*;
import java.util.*;

public class DaytimeMulticastClient{
public static final int defaultPort = 1234;

public static void main(String args[]) throws Exception {
        if (args.length > 1)
            throw new IllegalArgumentException("Syntax: DaytimeMulticastClient [<multicastgroup>]");
        InetAddress multicastGroup = InetAddress.getByName(args.length == 0 ? "234.5.6.7" : args[0]);
        MulticastSocket socket = new MulticastSocket(defaultPort);
        socket.joinGroup(multicastGroup);
        byte[] buffer = new byte[80];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        String str = new String(packet.getData());
        System.out.println("Time received from " + packet.getAddress() + " is: " + str);
    }
}
