/**
 * Класс, наследующий класс AudioDevice, реализующий интерфейсы PlayingFlashDrives, PlayingMusicalPlates, PlayingCDs
 * Реализует универсальный проигрыватель
 */
public class UniversalMusicPlayer extends AudioDevice implements PlayingFlashDrives, PlayingMusicalPlates, PlayingCDs{
    @Override
    public String toString(){
        return "Universal Musical Player";
    }

    /**
     * Функция проигрывания композиции
     * @param mp - носитель виниловая пластинка
     */
    public void playSong(MusicalPlate mp) {
        System.out.printf("%s %s, ", this,"Audio Device");
        System.out.println(mp.getSongList().getSong());
    }

    /**
     * Функция проигрывания композиции
     * @param fd - USP-флеш носитель
     */
    public void playSong(FlashDrive fd) {
        System.out.printf("%s %s, ", this,"Audio Device");
        System.out.println(fd.getSongList().getSong());
    }

    /**
     * Функция проигрывания композиции
     * @param cd - CD носитель
     */
    public void playSong(CD cd) {
        System.out.printf("%s %s, ", this,"Audio Device");
        System.out.println(cd.getSongList().getSong());
    }
}
