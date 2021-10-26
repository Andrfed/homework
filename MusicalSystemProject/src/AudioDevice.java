/**
 * Абстрактный класс, реализующий функции музыкального проигрывателя
 *
 */
public abstract class AudioDevice {
    /**
     * Конструктор по умолчанию
     */
    AudioDevice(){

    }

    /**
     * Функция проигрывания музыкальной композиции
     * @param mscr - любой музыкальный носитель
     * @see MusicCarrier
     */
    public void playSong(MusicCarrier mscr) {
        System.out.println("it cannot be played");
    }

    /**
     * Функция переключения на следующую музыкальную композицию
     * @param mscr - любой музыкальный носитель
     * @see MusicCarrier
     */
    public void setNextSong(MusicCarrier mscr){
        mscr.getSongList().nextSong();
    }

    /**
     * Функция переключения на предыдущую музыкальную композицию
     * @param mscr - любой музыкальный носитель
     * @see MusicCarrier
     */
    public void setPreviousSong(MusicCarrier mscr){
        mscr.getSongList().previousSong();
    }
    @Override
    public String toString(){
        return "Audio Device";
    }
}
