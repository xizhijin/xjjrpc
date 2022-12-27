import io.eric.rpc.consumer.common.RpcConsumer;
import io.eric.rpc.consumer.common.future.RPCFuture;
import io.eric.rpc.protocol.RpcProtocol;
import io.eric.rpc.protocol.header.RpcHeaderFactory;
import io.eric.rpc.protocol.request.RpcRequest;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class RpcConsumerHandlerTest {
    public static void main(String[] args) throws Exception {
        RpcConsumer consumer = RpcConsumer.getInstance();
        RPCFuture future = consumer.sendRequest(getRpcRequestProtocol());
        LOGGER.info("从服务消费者获取到的数据===>>>" + future.get());
        consumer.close();
    }

    private static RpcProtocol<RpcRequest> getRpcRequestProtocol() {
        //模拟发送数据
        RpcProtocol<RpcRequest> protocol = new RpcProtocol<>();
        protocol.setHeader(RpcHeaderFactory.getRequestHeader("jdk"));
        RpcRequest request = new RpcRequest();
        request.setClassName("io.eric.rpc.test.api.DemoService");
        request.setGroup("eric");
        request.setMethodName("hello");
        request.setParameters(new Object[]{"eric"});
        request.setParameterTypes(new Class[]{String.class});
        request.setVersion("1.0.0");
        request.setAsync(false);
        request.setOneway(false);
        protocol.setBody(request);
        return protocol;
    }
}
