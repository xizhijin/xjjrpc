package io.eric.rpc.protocol.header;

import io.eric.rpc.common.scanner.id.IdFactory;
import io.eric.rpc.constants.RpcConstants;
import io.eric.rpc.protocol.enumeration.RpcType;

/**
 * @author eric
 * @version 1.0.0
 * @description RpcHeaderFactory
 */
public class RpcHeaderFactory {

    public static RpcHeader getRequestHeader(String serializationType) {
        RpcHeader header = new RpcHeader();
        long requestId = IdFactory.getId();
        header.setMagic(RpcConstants.MAGIC);
        header.setRequestId(requestId);
        header.setMsgType((byte) RpcType.REQUEST.getType());
        header.setStatus((byte) 0x1);
        header.setSerializationType(serializationType);
        return header;
    }
}
