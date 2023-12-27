import java.io.FileInputStream;
import java.io.IOException;
//导入两个文件流
import java.io.BufferedReader;
import java.io.InputStreamReader;

//十六进制形式打印
public class ReadBinData {

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("student.bin");
            int byteData;
            int count = 0; // 添加一个计数器来跟踪每行的字节数

            while ((byteData = fileInputStream.read()) != -1) {
                // 打印出字节数据，以十六进制形式打印
                System.out.printf("%02X ", byteData);
                count++;

                // 每16个字节换行一次
                if (count == 46) {
                    System.out.println();
                    count = 0; // 重置计数器
                }
            }
            // 如果最后一行不足16个字节，确保在文件末尾后换行
            if (count > 0) {
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


/*
//不推荐以文本方式显示(打开也会乱码)！！！
public class ReadBinData {

    public static void main(String[] args) {

        try (FileInputStream fileInputStream =
                     new FileInputStream("student.bin");
             InputStreamReader inputStreamReader =
                     new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader =
                     new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

*/