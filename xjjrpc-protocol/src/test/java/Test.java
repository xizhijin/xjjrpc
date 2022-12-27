import io.eric.rpc.protocol.RpcProtocol;
import io.eric.rpc.protocol.header.RpcHeader;
import io.eric.rpc.protocol.header.RpcHeaderFactory;
import io.eric.rpc.protocol.request.RpcRequest;

/**
 * @author eric
 * @version 1.0.0
 * @description
 */
public class Test {

    public static RpcProtocol<RpcRequest> getRpcProtocol() {
        RpcHeader header = RpcHeaderFactory.getRequestHeader("jdk");

        RpcRequest body = new RpcRequest();
        body.setOneway(false);
        body.setAsync(false);
        body.setClassName("io.eric.rpc.demo.RpcProtocol");
        body.setMethodName("hello");
        body.setGroup("eric");
        body.setParameters(new Object[]{"eric"});
        body.setParameterTypes(new Class[]{String.class});
        body.setVersion("1.0.0");

        RpcProtocol<RpcRequest> protocol = new RpcProtocol<>();
        protocol.setBody(body);
        protocol.setHeader(header);
        return protocol;
    }
}
