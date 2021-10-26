/**
 * Интерфейс реализации возможности проигрывания USP-флеш носителя
 */
public interface PlayingFlashDrives {
    /**
     * Функция проигрывания композиции
     * @param fd - USP-флеш носитель носитель
     * @see FlashDrive
     */
    public void playSong(FlashDrive fd);
}
