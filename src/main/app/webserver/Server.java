package webserver;

/*package whatever //do not write package name here */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
    private static Selector selector = null;

    public static void main(String[] args)
    {

        try {
            selector = Selector.open();
            // We have to set connection host,port and
            // non-blocking mode
            ServerSocketChannel serverSocketChannel
                    = ServerSocketChannel.open();
            ServerSocket serverSocket
                    = serverSocketChannel.socket();
            serverSocket.bind(
                    new InetSocketAddress("localhost", 8089));
            serverSocketChannel.configureBlocking(false);
            int ops = serverSocketChannel.validOps();
            serverSocketChannel.register(selector, ops,
                    null);
            while (true) {
                selector.select();
                Set<SelectionKey> selectedKeys
                        = selector.selectedKeys();
                Iterator<SelectionKey> i
                        = selectedKeys.iterator();

                while (i.hasNext()) {
                    SelectionKey key = i.next();

                    if (key.isAcceptable()) {
                        // New client has been accepted
                        handleAccept(serverSocketChannel,
                                key);
                    }
                    else if (key.isReadable()) {
                        // We can run non-blocking operation
                        // READ on our client
                        handleRead(key);
                    }
                    i.remove();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void
    handleAccept(ServerSocketChannel mySocket,
                 SelectionKey key) throws IOException
    {

        System.out.println("Connection Accepted..");

        // Accept the connection and set non-blocking mode
        SocketChannel client = mySocket.accept();
        client.configureBlocking(false);

        // Register that client is reading this channel
        client.register(selector, SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey key)
            throws IOException
    {
        System.out.println("Reading client's message.");

        // create a ServerSocketChannel to read the request
        SocketChannel client = (SocketChannel)key.channel();

        // Create buffer to read data
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        client.read(buffer);

        // Parse data from buffer to String
        String data = new String(buffer.array()).trim();
        if (data.length() > 0) {
            System.out.println("Received message: " + data);
            if (data.equalsIgnoreCase(
                    "I Love KirikoChan")) {
                client.close();
                System.out.println("Connection closed...");
            }
        }
    }
}

