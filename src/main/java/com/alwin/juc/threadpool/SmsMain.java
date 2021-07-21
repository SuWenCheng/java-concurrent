package com.alwin.juc.threadpool;

public class SmsMain {

    public static void main(String[] args) {
        AsyncSmsVerificationCodePusher asyncSmsVerificationCodePusher = new AsyncSmsVerificationCodePusher();

        SmsVerificationCodeTask task1 = new SmsVerificationCodeTask(13763074811l);
        SmsVerificationCodeTask task2 = new SmsVerificationCodeTask(13453074811l);
        SmsVerificationCodeTask task3 = new SmsVerificationCodeTask(13712074811l);
        SmsVerificationCodeTask task4 = new SmsVerificationCodeTask(13763075011l);

        asyncSmsVerificationCodePusher.sendSmsVerificationCode(task1);
        asyncSmsVerificationCodePusher.sendSmsVerificationCode(task2);
        asyncSmsVerificationCodePusher.sendSmsVerificationCode(task3);
        asyncSmsVerificationCodePusher.sendSmsVerificationCode(task4);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
