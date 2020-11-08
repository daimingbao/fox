package cn.supfox.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class NettyClient {

    public static void main(String[] args) {

        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup worker = new NioEventLoopGroup(5);

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(boss);
        bootstrap.channel(NioServerSocketChannel.class);
        Bootstrap handler = bootstrap.handler(new ChannelInitializer() {


            @Override
            protected void initChannel(Channel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new ChannelDuplexHandler(){
                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        super.channelRead(ctx, msg);
                    }
                });
            }
        });


        bootstrap.connect(new InetSocketAddress("127.0.0.1", 1909));


    }


}
