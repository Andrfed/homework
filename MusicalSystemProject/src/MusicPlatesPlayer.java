/**
 * Класс, наследующий класс AudioDevice, реализующий интерфейс PlayingMusicalPlates
 * Реализует проигрыватель виниловых пластинок
 */
public class MusicPlatesPlayer extends AudioDevice implements PlayingMusicalPlates {
    @Override
    public String toString(){
        return "Music Plates Player";
    }

    /**
     * Функция проигрывания композиции
     * @param mp - носитель виниловая пластинка
     */
    public void playSong(MusicalPlate mp) {
        System.out.printf("%s %s, ", this,"Audio Device");
        System.out.println(mp.getSongList().getSong());
    }
}
