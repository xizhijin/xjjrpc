package io.eric.rpc.test.scanner;

import io.eric.rpc.annotation.RpcReference;
import io.eric.rpc.common.scanner.ClassScanner;
import io.eric.rpc.common.scanner.reference.RpcReferenceScanner;
import io.eric.rpc.common.scanner.server.RpcServiceScanner;
import org.junit.Test;

import java.util.List;

public class ScannerTest {

    /**
     * 测试通用扫描器：
     * 扫描io.eric.rpc.test.scanner包下所有的类
     */
    @Test
    public void testScannerClassNameList() throws Exception {
        List<String> classNameList = ClassScanner.getClassNameList("io.eric.rpc.test.scanner");
        classNameList.forEach(System.out::println);
    }

    /**
     * 测试@RpcService注解扫描器：
     * 扫描io.eric.rpc.test.scanner包下所有标注了@RpcService注解的类
     */
    @Test
    public void testScannerClassNameListByRpcService() throws Exception {
        RpcServiceScanner.doScannerWithRpcServiceAnnotationFilterAndRegistryService("io.eric.rpc.test.scanner");
    }

    /**
     * 测试@RpcReference注解扫描器：
     * 扫描io.eric.rpc.test.scanner包下所有标注了@RpcReference注解的类
     */
    @Test
    public void testScannerClassNameListByRpcReference() throws Exception {
        RpcReferenceScanner.doScannerWithRpcReferenceAnnotationFilter("io.eric.rpc.test.scanner");
    }





}
