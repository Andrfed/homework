import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileWordCounter {
    int getWordCount(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        int count = 0;
        while (in.hasNext()) {
            in.next();
            count++;
        }
        return count;
    }
}
