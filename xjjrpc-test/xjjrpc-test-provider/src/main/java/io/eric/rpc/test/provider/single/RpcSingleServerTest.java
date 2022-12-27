package io.eric.rpc.test.provider.single;

import io.eric.rpc.provider.RpcSingleServer;
import org.junit.Test;

public class RpcSingleServerTest {
    @Test
    public void startRpcSingleServer() {
//        RpcSingleServer singleServer = new RpcSingleServer("127.0.0.1:27880", "io.eric.rpc.test", "jdk");
        RpcSingleServer singleServer = new RpcSingleServer("127.0.0.1:27880", "io.eric.rpc.test", "cglib");
        singleServer.startNettyServer();
    }
}
