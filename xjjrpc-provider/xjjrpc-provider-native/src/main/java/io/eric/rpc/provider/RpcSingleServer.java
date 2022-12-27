package io.eric.rpc.provider;

import io.eric.rpc.common.scanner.server.RpcServiceScanner;
import io.eric.rpc.provider.common.server.base.BaseServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RpcSingleServer extends BaseServer {

    private final Logger logger = LoggerFactory.getLogger(RpcSingleServer.class);


    public RpcSingleServer(String serverAddress, String scanPackage, String reflectType) {
        //调用父类构造方法
        super(reflectType, serverAddress);
        try {
            this.handlerMap = RpcServiceScanner.doScannerWithRpcServiceAnnotationFilterAndRegistryService(scanPackage);
        } catch (Exception e) {
            logger.error("RPC Server init error", e);
        }
    }
}
