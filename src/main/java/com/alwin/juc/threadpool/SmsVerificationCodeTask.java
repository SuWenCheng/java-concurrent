package com.alwin.juc.threadpool;





import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class SmsVerificationCodeTask implements Runnable {

    //private final static Logger LOGGER = LoggerFactory.getLogger(SmsVerificationCodeTask.class);


    private long phoneNumber;

    public SmsVerificationCodeTask(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void run() {
        // 生成验证码
        int verificationCode = ThreadLocalRandom.current().nextInt(999999);
        DecimalFormat df = new DecimalFormat("000000");
        String txtVerificationCode = df.format(verificationCode);

        sendMessage(phoneNumber, txtVerificationCode);
    }

    private void sendMessage(long phoneNumber, String txtVerificationCode) {
        log.info("发送短信开始：phoneNumber->{}, txtVerificationCode->{}", phoneNumber, txtVerificationCode);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("发送短信结束：phoneNumber->{}, txtVerificationCode->{}", phoneNumber, txtVerificationCode);
    }
}
