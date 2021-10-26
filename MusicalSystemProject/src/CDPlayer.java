/**
 * Класс, наследующий класс AudioDevice, реализующий интерфейс PlayingCDs
 * Реализует CD проигрыватель
 */
public class CDPlayer extends AudioDevice implements PlayingCDs{
    @Override
    public String toString(){
        return "CD Player";
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
