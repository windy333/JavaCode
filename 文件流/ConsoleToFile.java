import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ConsoleToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text (type 'EOF' to finish):");

        // 使用try-with-resources确保流在结束时自动关闭
        try (FileOutputStream fileOutputStream =
                     new FileOutputStream("main.txt");
             OutputStreamWriter outputStreamWriter =
                     new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
             BufferedWriter bufferedWriter =
                     new BufferedWriter(outputStreamWriter)) {

            String line;
            while (!(line = scanner.nextLine()).equals("EOF")) {
                bufferedWriter.write(line);
                bufferedWriter.newLine(); // 写入换行符，以保持文本的换行
            }

            System.out.println("Text has been written to main.txt");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
