package com.liu.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUtils {

    public static final String IMAGE_DIR = "images"+ File.separator;


    //下载图片到本地
    public static String downloadImage(String imageSrc){
    // String fileExtension = getImageExtension(imageSrc);
        String fileExtension = ".png";
        String uniqueFileName = System.currentTimeMillis() + fileExtension;

        // 在当前目录下创建一个名为"images"的目录
        Path imagesDir = Paths.get(IMAGE_DIR);
        if (!Files.exists(imagesDir)) {
            try {
                Files.createDirectories(imagesDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 定义图片保存的路径
        Path outputPath = imagesDir.resolve(uniqueFileName);

        try {
            // 打开网络连接
            URL url = new URL(imageSrc);
            // 使用NIO将数据从网络复制到文件，同时为文件生成一个唯一的名称
            Files.copy(url.openStream(), outputPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image downloaded successfully: " + outputPath.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "../"+IMAGE_DIR + uniqueFileName;
    }

    private static String getImageExtension(String imageUrl) {
        // 获取查询参数前的URL部分
        String baseUrl = imageUrl.split("[\\?#]")[0];
        int lastIndexOfDot = baseUrl.lastIndexOf('.');
        return lastIndexOfDot == -1 ? "" : baseUrl.substring(lastIndexOfDot);
    }

}
