/**
 * Класс, реализующий тип данных продавец
 */
public class Seller {
    /**
     * ID продавца
     */
    private int sellerID;
    /**
     * фамилия продавца
     */
    private String surname;
    /**
     * имя продавца
     */
    private String name;

    /**
     * Конструктор с параметрами
     * @param sellerID ID продавца
     * @param surname фамилия продавца
     * @param name имя продавца
     */
    Seller(int sellerID, String surname, String name){
        this.sellerID = sellerID;
        this.name = name;
        this.surname = surname;
    }

    /**
     * Копирующий конструктор
     * @param seller объект класса Seller
     */
    Seller(Seller seller) {
        this.sellerID = seller.sellerID;
        this.name = seller.name;
        this.surname = seller.surname;
    }
    public int getSellerID() {
        return sellerID;
    }
    public String getSurname(){
        return surname;
    }
    public String getName(){
        return name;
    }
    public void setSellerID(int sellerID){
        this.sellerID = sellerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
