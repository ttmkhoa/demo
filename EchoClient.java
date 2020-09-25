import java.io.*;
import java.net.Socket;

public class EchoClient {
    public static void main(final String args[]) {
        try {
            final Socket s = new Socket(args[0], 6780);
            final InputStream is = s.getInputStream();
            final OutputStream os = s.getOutputStream(); // Lấy OutputStream
            for (int i = '1'; i <= '9'; i++) {
                os.write(i);
                final int ch = is.read();
                System.out.print((char) ch); // In ký tự nhận được ra màn hình
            }
        } catch (final IOException ie) {
     System.out.println("Loi: Khong tao duoc socket");
    }	//catch
}	//main
}