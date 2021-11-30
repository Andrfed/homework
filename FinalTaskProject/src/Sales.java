import java.time.LocalDate;

/**
 * Класс, реализующий тип данных продажи
 */
public class Sales {
    /**
     * ID продаж
     */
    private int salesID;
    /**
     * ID продавца
     */
    private int sellerID;
    /**
     * ID товара
     */
    private int productID;
    /**
     * количество проданных товаров
     */
    private int numberOfProduct;
    /**
     * дата продаж класса LocalDate
     * @see LocalDate
     */
    private LocalDate saleDate;

    /**
     * Конструктор с параметрами
     * @param salesID ID продаж
     * @param sellerID ID продавца
     * @param productID ID товара
     * @param numberOfProduct количество проданных товаров
     * @param saleDate дата продаж класса LocalDate
     */
    Sales(int salesID, int sellerID, int productID, int numberOfProduct, LocalDate saleDate){
        this.numberOfProduct = numberOfProduct;
        this.salesID = salesID;
        this.saleDate = saleDate;
        this.productID = productID;
        this.sellerID = sellerID;
    }

    /**
     * Копирующий конструктор
     * @param sales объект класса Sales
     */
    Sales(Sales sales){
        this.numberOfProduct = sales.numberOfProduct;
        this.salesID = sales.salesID;
        this.saleDate = sales.saleDate;
        this.productID = sales.productID;
        this.sellerID = sales.sellerID;
    }

    public int getProductID() {
        return productID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public int getSalesID() {
        return salesID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public void setSalesID(int salesID) {
        this.salesID = salesID;
    }
}
