import java.io.File;
import java. io. FileInputStream;
import java. io. IOException;

/*
说明：创建两个文件流打开c:\\test\\iotest路径下的f1.txt和f2.txt
并对比两个文件中的内容是否相同，最开始的时候如果这两个文件的大小不
相同，会直接设置false标签打印different

 */
public class Compare {
    public static void main(String[] args) throws IOException {
        boolean tag = true;

        //不会抛出异常而是去执行else里面的代码
        File path1= new File("c:\\test\\iotest\\f1.txt");
        File path2= new File("c:\\test\\iotest\\f2.txt");
        if (path1.exists() && path2.exists()) {

            FileInputStream f1 = new FileInputStream("c:\\test\\iotest\\f1.txt");
            FileInputStream f2 = new FileInputStream("c:\\test\\iotest\\f2.txt");
            if (f1.available() != f2.available()) {
                tag = false;
            } else {
                int d;
                while ((d = f1.read()) != -1) {
                    if (f2.read() != d) {
                        tag = false;
                        break;
                    }
                }
            }
            if (tag == true)
                System.out.println("same");
            else
                System.out.println("different");
            f1.close();
            f2.close();
        }else
            System.out.println("Path not found or txt not exsist");
    }
}
