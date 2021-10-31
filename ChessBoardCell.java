/**
 * Класс, представляющий реализацию клетки шахматного поля
 */
public class ChessBoardCell {
    /**
     * Номер клетки поля по горизонтали и вертикали соответственно
     */
    private int x, y;

    /**
     * Конструктор по умолчанию
     */
    ChessBoardCell(){

    }

    /**
     * Конструктор с параметрами, в случае неверно введённых параметров (клетки должны иметь номера от 0 до 7)
     * генерирует исключение IllegalArgumentException
     * @param x - номер клетки поля по горизонтали
     * @param y - номер клетки поля по вертикали
     * @throws IllegalArgumentException
     */
    ChessBoardCell(int x, int y) throws IllegalArgumentException{
        if ( (0 <= x && x <= 7) && (0 <= y && y <= 7) ) {
            this.x = x;
            this.y = y;
        }
        else {
            throw new IllegalArgumentException("Указана позиция за пределами доски");
        }
    }

    /**
     * Метод, возвращающий номер клетки поля по горизонтали
     * @return x - номер клетки поля по горизонтали
     */
    public int getX(){
        return x;
    }

    /**
     * Метод, возвращающий номер клетки поля по вертикали
     * @return y - номер клетки поля по вертикали
     */
    public int getY(){
        return y;
    }

    /**
     * Метод, устанавливающий номер клетки поля по горизонтали,
     * в случае неверно введённого значения (клетки должны иметь номера от 0 до 7) генерируется
     * исключение IllegalArgumentException
     * @param x - номер клетки поля по горизонтали
     * @throws IllegalArgumentException
     */
    public void setX(int x) throws IllegalArgumentException{
        if (0 <= x && x <= 7) {
            this.x = x;
        }
        else {
            throw new IllegalArgumentException("Указана позиция за пределами доски");
        }
    }

    /**
     * Метод, устанавливающий номер клетки поля по вертикали,
     * в случае неверно введённого значения (клетки должны иметь номера от 0 до 7) генерируется
     * исключение IllegalArgumentException
     * @param y - номер клетки поля по вертикали
     * @throws IllegalArgumentException
     */
    public void setY(int y) throws IllegalArgumentException{
        if (0 <= y && y <= 7) {
            this.y = y;
        }
        else {
            throw new IllegalArgumentException("Указана позиция за пределами доски");
        }
    }
    @Override
    /**
     * Представление в виде <номер по горизонтали в виде буквы от 'a' до 'h'><номер строки, начиная с 1>
     */
    public String toString(){
        return String.format("%c%d",'a' + y, x + 1);
    }
}
