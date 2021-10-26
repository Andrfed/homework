import java.util.Objects;

/**
 * Класс, реализующий музыкальную композицию
 */
public class Song {
    /**
     * Название музыкальной композиции
     */
    private String title;
    /**
     * Исполнитель музыкальной композиции
     */
    private String performer;

    /**
     * Конструктор по умолчанию
     */
    Song() {

    }

    /**
     * Конструктор с параметрами
     * @param title - название музыкальной композиции
     * @param performer - Исполнитель музыкальной композиции
     */
    Song(String title, String performer){
        this.title = title;
        this.performer = performer;
    }

    /**
     * Функция получения исполнителя музыкальной композиции
     * @return performer - исполнитель музыкальной композиции
     */
    public String getPerformer(){
        return performer;
    }

    /**
     * Функция получения названия музыкальной композиции
     * @return title - название музыкальной композиции
     */
    public String getTitle(){
        return title;
    }

    /**
     * Функция установки названия музыкальной композиции
     * @param title - название музыкальной композиции
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Функция установки исполнителя музыкальной композиции
     * @param performer - исполнитель музыкальной композиции
     */
    public void setPerformer(String performer){
        this.performer = performer;
    }
    @Override
    public String toString(){
        return String.format("Song - %s, performer - %s", title, performer);
    }
    @Override
    public boolean equals(Object other){
        if (other == null){
            return false;
        }
        if (!(other instanceof Song)) {
            return false;
        }
        Song otherSong = (Song) other;
        if (this.title.equals(otherSong.title) && this.performer.equals(otherSong.performer)) {
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public int hashCode(){
        return Objects.hash(this);
    }
}
