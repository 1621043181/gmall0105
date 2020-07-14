package com.atguigu.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageServiceApplicationTests {

    @Test
    public void contextLoads() throws IOException, MyException {
        //配置fdfs的全局连接地址
        String file_name = "F:\\javaEE培训\\gmall0105\\gmall-manage-web\\src\\main\\resources\\tracker.conf";

        ClientGlobal.init(file_name);

        TrackerClient trackerClient = new TrackerClient();
        //获取一个trackerServer的实列
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        //通过tracker获取一个storage连接客户端
        StorageClient storageClient = new StorageClient(trackerServer, null);

        String[] uploadInfos = storageClient.upload_file("D:/A.jpg", "jpg", null);

        String url = "http://192.168.189.134";

        for (String uploadInfo : uploadInfos) {
            url += "/" + uploadInfo;
        }
        System.out.println(url);
    }

}
