import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Writter {

    private String fileName = "test.html";

    public Writter(String fileName) {
        this.fileName = fileName;
    }

    public void deleteFile() {
        File file = new File(this.fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    public void writeFile(String content) throws IOException {
        File file = new File(this.fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(this.fileName, true);
        writer.write(content);
        writer.close();
    }
}
