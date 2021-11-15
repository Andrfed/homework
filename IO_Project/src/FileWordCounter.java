import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Класс, тспользуемый для подсчёта слов в файле
 */
public class FileWordCounter {
    /**
     * Функция нахождения количества слов в файле.
     * В случае отсутствия заданного файла, вызывает исключение FileNotFoundException
     * @param file объект класса File
     * @return count количество слов в файле
     * @throws FileNotFoundException
     * @see File
     */
    int getWordCount(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        int count = 0;
        // Пока можно читать слова из файла, читаем слово и прибавляем к ответу 1
        while (in.hasNext()) {
            in.next();
            count++;
        }
        return count;
    }
}
