package com.alwin.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * IO密集型业务线程池
 */
public class AsyncSmsVerificationCodePusher {

    private static final ExecutorService SMS_SEND_THREAD_POOL =
            new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1,   // 核心数为CPU数+1
                    50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000),
                    r -> {
                        Thread thread = new Thread(r, "sms_send_thred_pool");
                        thread.setDaemon(true);
                        return thread;
                    }) ;

    public void sendSmsVerificationCode(SmsVerificationCodeTask task){
        SMS_SEND_THREAD_POOL.submit(task);
    }
}
