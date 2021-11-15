import java.io.File;
import java.io.FileNotFoundException;

/**
 * Класс для тестирования класса FileWordCounter
 * @see FileWordCounter
 */
public class TestFileWordCounter {

    public static void main(String[] args) throws IllegalArgumentException{
        // В качестве имени файла берётся первый параметр из консоли.
        // Если первый параметр не задан, вызываем исключение IllegalArgumentException.
        // Если файла с заданным именем нет, то обрабатываем исключение FileNotFoundException и
        // печатаем, что файл не найден.
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
