import java.util.concurrent.Callable;

/**
 * Класс, реализующий интерфейс Callable,
 * Описывает задание для Matcher для использования с потоками.
 * @see Callable
 * @see Matcher
 */
public class MatcherTask implements Callable<Integer> {
    /**
     * Входная строка.
     */
    private String INPUT_STRING;
    /**
     * Шаблон поиска.
     */
    private String TEMPLATE;

    /**
     * Конструктор с параметрами
     * @param INPUT_STRING - Входная строка
     * @param TEMPLATE - Шаблон поиска
     */
    MatcherTask(String INPUT_STRING, String TEMPLATE){
        this.INPUT_STRING = INPUT_STRING;
        this.TEMPLATE = TEMPLATE;
    }
    @Override
    public Integer call() throws Exception {
        if (Matcher.match(INPUT_STRING, TEMPLATE)) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
