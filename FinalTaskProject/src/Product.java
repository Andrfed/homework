/**
 * Класс, реализующий товар
 */
public class Product {
    /**
     * ID товара
     */
    private int productID;
    /**
     * наименование товара
     */
    private String productName;

    /**
     * Конструктор с параметрами
     * @param productID ID товара
     * @param productName наименование товара
     */
    Product(int productID, String productName) {
        this.productID = productID;
        this.productName = productName;
    }

    /**
     * Копирующий конструктор
     * @param product объект класса Product
     */
    Product(Product product) {
        this.productName = product.productName;
        this.productID = product.productID;
    }

    public int getProductID() {
        return productID;
    }
    public String getProductName(){
        return productName;
    }
    public void setProductID(int productId){
        this.productID = productId;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    @Override
    public boolean equals(Object other){
        if (other == null) {
            return false;
        }
        if (!(other instanceof Product)) {
            return false;
        }
        // Товары считаются одинаковыми, если равны их ID
        if (((Product) other).getProductID() == this.getProductID()) {
            return true;
        }
        else {
            return false;
        }
    }
    public int hashCode(){
        return productID;
    }
}
