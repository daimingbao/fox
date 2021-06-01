package cn.supfox.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.buffer.UnpooledDirectByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import lombok.SneakyThrows;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.util.List;

public class NettyClient {

    private static class TimeDecoder extends ByteToMessageDecoder { // (1)
        @Override
        protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) { // (2)
            if (in.readableBytes() < 4) {
                return; // (3)
            }

            out.add(in.readBytes(4)); // (4)
        }
    }



    static class DiscardServerHandler extends ChannelInboundHandlerAdapter { // (1)


        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
//            super.channelActive(ctx);
//            String msg = "hello Server!";
//            ByteBuf encoded = ctx.alloc().buffer(4 * msg.length());
//            encoded.writeBytes(msg.getBytes());
//            ctx.write(encoded);
//            ctx.flush();
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)

            ByteBuf result = (ByteBuf) msg;
            byte[] bytesMsg = new byte[result.readableBytes()];
            // msg中存储的是ByteBuf类型的数据，把数据读取到byte[]中
            result.readBytes(bytesMsg);
            String resultStr = new String(bytesMsg);
            // 接收并打印客户端的信息
            System.out.println("server sid said:" + resultStr);
            // Discard the received data silently.
            ((ByteBuf) msg).release(); // (3)
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
            System.out.println("hello");
            // Close the connection when an exception is raised.
            cause.printStackTrace();
            ctx.close();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        NioEventLoopGroup worker = new NioEventLoopGroup(5);

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(worker).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {


            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline
                        .addLast(new DiscardServerHandler());
            }
        });


        ChannelFuture connect = bootstrap.connect(new InetSocketAddress("127.0.0.1", 1901)).sync();

        Channel channel1 = connect.channel();


        for (int i=0; i< 20; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    while (true) {

                        Thread.sleep(5000);

                        synchronized (this) {
                            String msg = "hello Server! my is thread "+ finalI;
                            ByteBuf encoded = new UnpooledDirectByteBuf(new UnpooledByteBufAllocator(true),

                                    1024,2048);
                            encoded.writeBytes(msg.getBytes());
                            channel1.write(encoded);
                            channel1.flush();
                        }

                    }
                }
            }).start();

        }


    }


}
