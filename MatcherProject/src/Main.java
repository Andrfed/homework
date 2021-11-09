import java.sql.Array;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Стартовый класс.
 */
public class Main {

    /**
     * Пример входной строки.
     */
    public static final String INPUT_STRING = "Невежество есть мать промышленности, как и суеверий." +
            " Сила размышления и воображения подвержена ошибкам; но привычка двигать рукой или ногой" +
            " не зависит ни от того, ни от другого. Поэтому мануфактуры лучше всего процветают там, где" +
            " наиболее подавлена духовная жизнь, так что мастерская может рассматриваться как машина," +
            " части которой составляют люди.";

    /**
     * Шаблон поиска символов в строке.
     */
    public static final String TEMPLATE = " ";

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long current = System.currentTimeMillis();

        int sum = 0;
        // Создаём пул потоков
        ExecutorService pool = Executors.newFixedThreadPool(INPUT_STRING.length());
        // Создаём список задач для Matcher
        ArrayList<FutureTask> TaskArray = new ArrayList<FutureTask>(INPUT_STRING.length());

        for (int i = 0; i < INPUT_STRING.length(); i++) {
            // Задаём задачу для Matcher
            MatcherTask task = new MatcherTask(String.valueOf(INPUT_STRING.charAt(i)), TEMPLATE);
            // Добавляем задачу в список задач
            TaskArray.add(new FutureTask(task));
            // Отдаём задачу потоку для решения
            pool.submit(TaskArray.get(i));
        }

        for (int i = 0; i < INPUT_STRING.length(); i++) {
            // Получаем задачу из списка задач
            FutureTask task = TaskArray.get(i);
            // Получаем ответ на задачу
            sum += (Integer) task.get();
        }
        // Останавливаем потоки
        pool.shutdown();

        System.out.println("Count of space: " + sum);

        System.out.println("Time: " + (System.currentTimeMillis() - current) / 1000 + " c.");
    }
}
