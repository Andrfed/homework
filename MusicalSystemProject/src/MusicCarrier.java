import java.util.Objects;

/**
 * Абстрактный класс, представляющий реализацию музыкального носителя.
 *
 */
public abstract class MusicCarrier {
    /**
     * Объект класса SongList - список музыкальных композиций, сохранённых на носителе
     * @see SongList
     */
    private SongList songList;

    /**
     * Конструктор по умолчанию
     */
    MusicCarrier(){
        this.songList = new SongList();
    }

    /**
     * Функция, возвращающая список музыкальных композиций, сохранённых на носителе
     * @return songList - возвращающая список музыкальных композиций
     * @see SongList
     */
    public SongList getSongList(){
        return songList;
    }
    @Override
    public String toString(){
        return "Music Carrier";
    }
    @Override
    public boolean equals(Object other){
        if (other == null){
            return false;
        }
        if (!(other instanceof MusicCarrier)) {
            return false;
        }
        MusicCarrier otherMusicCarrier = (MusicCarrier) other;
        if (this.songList.equals(otherMusicCarrier.songList)) {
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
