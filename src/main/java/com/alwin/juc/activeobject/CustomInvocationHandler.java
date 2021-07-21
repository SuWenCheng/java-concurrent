package com.alwin.juc.activeobject;

import lombok.AllArgsConstructor;
import org.omg.PortableServer.Servant;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Active Object模式中的Proxy角色
 */
@AllArgsConstructor
public class CustomInvocationHandler implements InvocationHandler {

    private Object target;
    private ExecutorService scheduler;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Callable<Object> methodRequest = () -> {

            System.out.println("处理逻辑");

            return null;
        };

        Future<Object> future = scheduler.submit(methodRequest);

        return future;
    }

    @SuppressWarnings("unchecked")
    public <T> T newInstance(Class<T> interfaces, ExecutorService scheduler, Servant servant) {
        CustomInvocationHandler handler = new CustomInvocationHandler(servant, scheduler);
        T proxy = (T) Proxy.newProxyInstance(interfaces.getClassLoader(),
                new Class[]{interfaces}, handler);
        return proxy;
    }

}
