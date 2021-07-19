package com.alwin.juc.promise.clouduploader;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CloudUploaderPromisor {

    public static Future<CloudUploader> newCloudUploaderPromise(CloudSyncConfig cloudSyncConfig) {
        FutureTask<CloudUploader> futureTask = new FutureTask<>(() -> {
            CloudUploader cloudUploader = new DefaultCloudUploader();
            System.out.println("云盘开始建立连接");
            cloudUploader.init(cloudSyncConfig.getCloudAddress(), cloudSyncConfig.getUsername(),
                    cloudSyncConfig.getPassword(), cloudSyncConfig.getServerDir());
            Thread.sleep(5000);
            return cloudUploader;
        });

        new Thread(futureTask).start();
        return futureTask;
    }

}
