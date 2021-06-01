package cn.supfox.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.io.IOException;

public class NettyServer {

    static class DiscardServerHandler extends ChannelInboundHandlerAdapter { // (1)

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)

            ByteBuf result = (ByteBuf) msg;
            byte[] bytesMsg = new byte[result.readableBytes()];
            // msg中存储的是ByteBuf类型的数据，把数据读取到byte[]中
            result.readBytes(bytesMsg);
            String resultStr = new String(bytesMsg);
            // 接收并打印客户端的信息
            System.out.println("========");
            System.out.println("client sid said:" + resultStr);
            System.out.println("!!!!!!!");

            // 向客户端发送消息
            String response = "hello client!";
            // 在当前场景下，发送的数据必须转换成ByteBuf数组
            ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
            encoded.writeBytes(response.getBytes());
            ctx.write(encoded);
            ctx.flush();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
            // Close the connection when an exception is raised.
            cause.printStackTrace();
            ctx.close();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {


        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup worker = new NioEventLoopGroup(5);

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(boss, worker).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new DiscardServerHandler()).addLast();
            }
        });

        ChannelFuture bind = serverBootstrap.bind(1901).sync();


        bind.addListener((ChannelFutureListener) future -> {
            if (future.isSuccess()) {
                System.out.println("push server bind on port: " );
            } else {
                System.out.println(("push server bind error: "+ future.cause()));
            }
        });

        System.out.println("服务启动了 1901");


        System.in.read();
    }
}
