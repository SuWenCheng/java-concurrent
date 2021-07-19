package com.alwin.juc.promise;

import lombok.Data;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MakeTeaPromisor {

    public static Future<BoilWater> create(long startTime) {
        FutureTask<BoilWater> futureTask = new FutureTask<>(() -> {
            System.out.println("开始烧水，当前用时" + (System.currentTimeMillis() - startTime) + "ms");
            BoilWater boilWater = new BoilWater();
            Thread.sleep(15000);
            boilWater.setStatus(true);
            return boilWater;
        });

        new Thread(futureTask).start();
        return futureTask;
    }

    @Data
    public static class BoilWater {
        private boolean status = false;
    }

    @Data
    public static class TeaAndCup {
        private boolean status;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();

        // 1.通过Promisor的create获取promise
        Future<BoilWater> promise = MakeTeaPromisor.create(startTime);

        // 2.开始准备茶叶茶杯任务
        System.out.println("准备茶杯茶叶，需要3分钟，当前用时" + (System.currentTimeMillis() - startTime) + "ms");
        TeaAndCup teaAndCup = new TeaAndCup();
        Thread.sleep(3000);
        teaAndCup.setStatus(true);
        System.out.println("准备茶杯茶叶结束，当前用时" + (System.currentTimeMillis() - startTime) + "ms");

        // 3.获取promise结果
        if (!promise.isDone()) {
            System.out.println("等待烧水完成");
        }

        // 4.等待promise完成
        BoilWater boilWater = promise.get();
        System.out.println("烧水信号：" + boilWater.isStatus() + "烧水完成，总耗时" + (System.currentTimeMillis() - startTime) + "ms");
    }

}
