import java.io.File;
import java.io.FileNotFoundException;

public class TestFileWordCounter {

    public static void main(String[] args) throws IllegalArgumentException{
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        try {
            File file = new File(args[0]);
            FileWordCounter fwc = new FileWordCounter();
            int count = 0;
            count = fwc.getWordCount(file);
            System.out.printf("Количество слов в файле: %d%n", count);
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
