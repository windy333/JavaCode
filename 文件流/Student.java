import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {
    // 继承Serializable接口使Student序列化
    private String ID;
    private double score;
    private String name;
    private LocalDate creationDate; // 添加一个LocalDate成员变量来存储创建日期

    public Student(String ID, double score, String name) {
        this.ID = ID;
        this.score = score;
        this.name = name;
        this.creationDate = LocalDate.now(); // 初始化创建日期为当前日期
        // 输出学号、姓名、成绩和创建日期
        System.out.println("学号：" + ID + " 姓名：" + name + " 成绩：" + score +
                " 创建日期：" + creationDate);
    }


    public static void main(String[] args) {
        Student student1 = new Student("01", 75, "张1");
        Student student2 = new Student("02", 85, "张2");
        Student student3 = new Student("03", 95, "张3");
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream("student.bin"));
            outputStream.writeObject(student1);
            outputStream.writeObject(student2);
            outputStream.writeObject(student3);
            outputStream.close();
            System.out.println("信息已全部保存为“bin”格式文件");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
