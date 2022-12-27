package io.eric.rpc.test.scanner.provider;

import io.eric.rpc.annotation.RpcService;
import io.eric.rpc.test.scanner.service.DemoService;

/**
 * @author eric
 * @version 1.0.0
 * @description DemoService实现类
 */
@RpcService(interfaceClass = DemoService.class, interfaceClassName = "io.eric.rpc.test.scanner.service.DemoService", version = "1.0.0", group = "eric")
public class ProviderDemoServiceImpl implements DemoService {

}
