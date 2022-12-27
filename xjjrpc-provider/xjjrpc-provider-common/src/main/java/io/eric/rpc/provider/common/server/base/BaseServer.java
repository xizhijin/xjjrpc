package io.eric.rpc.provider.common.server.base;

import io.eric.rpc.codec.RpcDecoder;
import io.eric.rpc.codec.RpcEncoder;
import io.eric.rpc.provider.common.handler.RpcProviderHandler;
import io.eric.rpc.provider.common.server.api.Server;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class BaseServer implements Server {

    private final Logger logger = LoggerFactory.getLogger(BaseServer.class);

    //主机域名或者IP地址
    protected String host = "127.0.0.1";

    //端口号
    protected int port = 27110;

    //存储的是实体类关系
    protected Map<String, Object> handlerMap = new HashMap<>();

    private String reflectType;

    public BaseServer(String reflectType, String serverAddress) {
        if (!StringUtils.isEmpty(serverAddress)) {
            String[] serverArray = serverAddress.split(":");
            this.host = serverArray[0];
            this.port = Integer.parseInt(serverArray[1]);
        }
        this.reflectType = reflectType;
    }

    @Override
    public void startNettyServer() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel channel) throws Exception {
                    channel.pipeline()
                            .addLast(/*new StringDecoder()*/new RpcDecoder())
                            .addLast(/*new StringEncoder()*/new RpcEncoder())
                            .addLast(new RpcProviderHandler(reflectType, handlerMap));
                }
            }).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture future = bootstrap.bind(host, port).sync();
            logger.info("Server started on {}:{}", host, port);
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.error("RPC Server start error", e);
        } finally {
             workerGroup.shutdownGracefully();
             bossGroup.shutdownGracefully();
        }
    }
}
