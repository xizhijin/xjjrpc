package io.eric.rpc.protocol;

import io.eric.rpc.protocol.header.RpcHeader;

import java.io.Serializable;

public class RpcProtocol<T> implements Serializable {
    private static final long serialVersionUID = 23386668366335L;

    /**
     * 消息头
     */
    private RpcHeader header;
    /**
     * 消息体
     */
    private T body;

    public RpcHeader getHeader() {
        return header;
    }

    public void setHeader(RpcHeader header) {
        this.header = header;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

}
