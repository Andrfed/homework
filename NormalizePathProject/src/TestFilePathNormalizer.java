/**
 * Класс для тестирования класса FilePathNormalizer
 * @see FilePathNormalizer
 */
public class TestFilePathNormalizer {
    public static void main(String[] args) {
        String path = "КРОК/task_6_2/src/./../../task_6_1/../../../мемы/котики";
        FilePathNormalizer fpn = new FilePathNormalizer();
        System.out.println(fpn.getNormalizedPath(path));
    }
}
