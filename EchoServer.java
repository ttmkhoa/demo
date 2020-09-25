import java.net.*; 
import java.io.*;

public class EchoServer {
    public static int defaultPort = 6780; 
    public static void main( final String[] args) {
        try {
            final ServerSocket ss = new ServerSocket(defaultPort);
            while (true) {
                try {
                    final Socket s = ss.accept();
                    final OutputStream os = s.getOutputStream();
                    final InputStream is = s.getInputStream();
                    int ch = 0;
                    while (true) {
                        ch = is.read();
                        if (ch == -1)
                            break;
                        os.write(ch);
                    }
                    s.close();
                } catch (final IOException e) {
                    System.err.println("  Connection Error: " + e);
                }
            }
        } catch (final IOException e) {
            System.err.println(" Server Creation Error:"+e);
        }
}
}
