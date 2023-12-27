import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileOutput {

    // 以utf-8形式并利用缓冲流读取文件显示在控制台中
    public static void main(String[] args) {
        try {
            // 使用BufferedInputStream包装FileInputStream
            BufferedInputStream fileInput = new BufferedInputStream(
                    new FileInputStream("C:\\Users\\Leon\\Desktop\\work" +
                            "\\following.txt"));

            // 使用ByteArrayOutputStream来捕获读取的数据
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int bytesRead;
            byte[] data = new byte[1024]; // 通常使用更小的缓冲区，例如1024字节

            // 读取数据到缓冲区，并写入ByteArrayOutputStream
            while ((bytesRead = fileInput.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, bytesRead);
            }

            // 将ByteArrayOutputStream转换为字符串
            String str = buffer.toString(StandardCharsets.UTF_8.name());

            // 打印到控制台
            System.out.println(str);

            // 关闭流
            fileInput.close();
            buffer.close();

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}

