package webserver;
/*package whatever //do not write package name here */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args)
    {
        try {
            String[] messages
                    = { "Non-Blocking servers are the best.",
                    "I Love GeeksForGeeks",
                    "I Love KirikoChan" };
            System.out.println(
                    "Connection accepted by the Server..");
            SocketChannel client = SocketChannel.open(
                    new InetSocketAddress("localhost", 8089));

            for (String msg : messages) {
                ByteBuffer buffer
                        = ByteBuffer.allocate(1024);
                buffer.put(msg.getBytes());
                buffer.flip();
                int bytesWritten = client.write(buffer);
                System.out.println(String.format(
                        "Sending Message: %s\nbufforBytes: %d",
                        msg, bytesWritten));
            }

            client.close();
            System.out.println("Client connection closed");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

