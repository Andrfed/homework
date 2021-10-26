/**
 * Класс, наследующий класс AudioDevice, реализующий интерфейс PlayingFlashDrives
 * Реализует USB-флеш проигрыватель
 */
public class FlashDrivesPlayer extends AudioDevice implements PlayingFlashDrives{
    @Override
    public String toString(){
        return "Flash Drives Player";
    }

    /**
     * Функция проигрывания композиции
     * @param fd - USP-флеш носитель
     */
    public void playSong(FlashDrive fd) {
        System.out.printf("%s %s, ", this,"Audio Device");
        System.out.println(fd.getSongList().getSong());
    }
}
