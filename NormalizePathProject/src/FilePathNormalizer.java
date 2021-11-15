import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Класс, используемый для нормализации файлового пути.
 */
public class FilePathNormalizer {
    /**
     * Функция нормализации пути.
     * @param path нормализуемый путь.
     * @return newPath нормализованный путь.
     */
    String getNormalizedPath(String path) {
        // В списке будем хранить имена директорий
        List<String> L = List.of(path.split("/"));
        // Исользуем дек в качестве стека
        Deque<String> St = new ArrayDeque<>();
        for (String str : L) {
            // Та же директория, удаляем из пути
            if (str.equals(".")) {
                continue;
            }
            // Нужно подняться вверх на одну директорию
            else if (str.equals("..")) {
                // Если невозможно подняться выше или или нужно поднятся ещё выше - добавляем в путь
                if (St.isEmpty() || St.getLast().equals("..")) {
                    St.addLast(str);
                }
                // Если можно подняться
                else {
                    St.removeLast();
                }
            }
            // Название директории, добавляем в путь
            else {
                St.addLast(str);
            }
        }
        // Переводим стек в строку
        String newPath = "";
        for (String str : St) {
            newPath = newPath.concat(str);
            newPath = newPath.concat("/");
        }
        // Удаляем лишний '/'
        newPath = newPath.substring(0, newPath.length() - 1);
        return newPath;
    }
}
