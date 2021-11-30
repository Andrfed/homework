/**
 * Класс, реализующий тип данных товар, предоставляемый продавцом
 */
public class ProductFromSeller {
    /**
     * ID продавца
     */
    private int sellerID;
    /**
     * ID товара
     */
    private int productID;
    /**
     * стоимость товара
     */
    private int cost;
    /**
     * количество товара
     */
    private int number;

    /**
     * Конструктор с параметрами
     * @param sellerID ID продавца
     * @param productID ID товара
     * @param cost стоимость товара
     * @param number количество товара
     */
    ProductFromSeller(int sellerID, int productID, int cost, int number){
        this.sellerID = sellerID;
        this.productID = productID;
        this.cost = cost;
        this.number = number;
    }

    /**
     * Копирующий конструктор
     * @param productFromSeller объект класса ProductFromSeller
     */
    ProductFromSeller(ProductFromSeller productFromSeller){
        this.sellerID = productFromSeller.sellerID;
        this.productID = productFromSeller.productID;
        this.cost = productFromSeller.cost;
        this.number = productFromSeller.number;
    }

    public int getSellerID() {
        return sellerID;
    }

    public int getCost() {
        return cost;
    }

    public int getProductID() {
        return productID;
    }

    public int getNumber() {
        return number;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }
}
