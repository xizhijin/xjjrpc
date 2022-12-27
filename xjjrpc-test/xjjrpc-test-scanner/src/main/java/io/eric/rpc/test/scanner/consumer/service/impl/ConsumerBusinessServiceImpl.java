package io.eric.rpc.test.scanner.consumer.service.impl;

import io.eric.rpc.annotation.RpcReference;
import io.eric.rpc.test.scanner.consumer.service.ConsumerBusinessService;
import io.eric.rpc.test.scanner.service.DemoService;

/**
 * @author eric
 * @version 1.0.0
 * @description 服务消费者业务逻辑实现类
 */
public class ConsumerBusinessServiceImpl implements ConsumerBusinessService {
    @RpcReference(registryType = "zookeeper", registryAddress = "127.0.0.1:2181", version = "1.0.0", group = "eric")
    private DemoService demoService;
}
