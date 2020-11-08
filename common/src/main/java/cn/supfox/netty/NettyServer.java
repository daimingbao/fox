package cn.supfox.netty;

import io.lettuce.core.resource.EventLoopGroupProvider;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class NettyServer {

    public static void main(String[] args) throws InterruptedException {


        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup worker = new NioEventLoopGroup(5);

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        ServerBootstrap group = serverBootstrap.group(boss, worker);

        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.childHandler(new ChannelInitializer() {
            @Override
            protected void initChannel(Channel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new SimpleChannelInboundHandler<TextWebSocketFrame>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
                        String text = msg.text();
                        System.out.println(text);
                    }
                });
            }
        });

        serverBootstrap.bind(1909).sync();
    }
}
