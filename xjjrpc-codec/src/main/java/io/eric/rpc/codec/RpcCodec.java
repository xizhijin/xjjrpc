package io.eric.rpc.codec;

import io.eric.rpc.serialization.api.Serialization;
import io.eric.rpc.serialization.jdk.JdkSerialization;

public interface RpcCodec {

    default Serialization getJdkSerialization() {
        return new JdkSerialization();
    }
}
