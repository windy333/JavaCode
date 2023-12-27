import java. io.*;

public class ShowDir {
    //显示目录下的子目录或文件
    private static void showDirInfo(File list[]){
        for (int i = 0; i < list. length; i++){
            if (list[i]. isDirectory())
                System. out. print("DIRECTORY");
            else
                System. out. print(list[i]. length() + " bytes");
            System. out. println("\t" + list[i]);
        }
    }

    public static void main(String[] args) {
        File path= new File("c:"+File. separator+"Program Files");
        if (path. exists() && path. isDirectory())
            showDirInfo(path. listFiles());
        else
            System. out. println("Path not found or not directory");
    }
}
