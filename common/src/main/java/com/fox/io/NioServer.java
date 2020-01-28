package com.fox.io;

import io.netty.channel.local.LocalAddress;
import org.apache.ibatis.annotations.SelectKey;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author dmb
 * @since 2020/1/19
 */
public class NioServer {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel server = ServerSocketChannel.open();
        server.configureBlocking(false);
        server.bind(new InetSocketAddress(8080));

        Selector selector = Selector.open();

        server.register(selector, SelectionKey.OP_ACCEPT);

        ByteBuffer byteBuffer =  ByteBuffer.allocate(1024);
        while (true) {
            int select = selector.select();
            if (select == 0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                        try {
                            SocketChannel accept = channel.accept();
                            if (null != accept) {
                                accept.configureBlocking(false);
                                accept.register(selector, SelectionKey.OP_READ);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    if (selectionKey.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        try {
                            socketChannel.read(byteBuffer);

                            String s = new String(byteBuffer.array());
                            System.out.println("hello: " + s);
                            byteBuffer.clear();
                            socketChannel.write(ByteBuffer.wrap(new String("aa").getBytes()));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    iterator.remove();
            }

        }
    }

}
