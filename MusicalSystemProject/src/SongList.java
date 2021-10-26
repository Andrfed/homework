import java.util.ArrayList;
import java.util.Objects;

/**
 * Класс, реализующий список музыкальных композиций
 */
public class SongList {
    /**
     * Объект класса ArrayList - список музыкальных композиций
     */
    private ArrayList songlist;
    /**
     * Индекс текущей композиции
     */
    private int index;

    /**
     * Конструктор по умолчанию
     * Список композиций изначально пуст,
     * Индекс текущей позиции равен 0
     */
    SongList(){
        songlist = new ArrayList<Song>();
        index = 0;
    }
    /**
     * Функция перехода к следущей композиции
     * Если список закончился, то переход не осуществляется
     */
    public void nextSong(){
        if (index < songlist.size()) {
            index++;
        }
    }

    /**
     * Функция перехода к предыдущей композиции
     * Если список закончился, то переход не осуществляется
     */
    public void previousSong(){
        if (index > 0) {
            index--;
        }
    }

    /**
     * Функция получения текущей музыкальной композиции
     * @return объект класса Song - текущая музыкальная композиция
     * @see Song
     */
    public Song getSong(){
        return ((Song)songlist.get(index));
    }

    /**
     * Функция добавления композиции в список
     * Композиция добавляется в конец списка
     * @param song - добавляемая музыкальная композиция
     * @see Song
     */
    public void addSong(Song song){
        songlist.add(song);
    }

    /**
     * Функция удаления музыкальной композиции
     * Удаляется текущая композиция
     */
    public void removeSong() {
        songlist.remove(index);
        previousSong();
    }
    @Override
    public String toString(){
        return "Song List";
    }
    @Override
    public boolean equals(Object other){
        if (other == null){
            return false;
        }
        if (!(other instanceof SongList)) {
            return false;
        }
        SongList otherSongList = (SongList) other;
        if (this.songlist.equals(otherSongList.songlist)) {
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
