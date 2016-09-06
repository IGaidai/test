import java.io.FileWriter;

public class WriteAFile {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("C:\\dev\\files\\Foo.txt");
            fileWriter.write("Buska");
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
