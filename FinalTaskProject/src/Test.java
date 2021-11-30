import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        ProductFileParser pfp = new ProductFileParser();
        File file = new File("ProductInput.xml");
        // Получаем список товаров
        List<Product> productList = pfp.inputFromFile(file);
        Map<Product, Integer> productIntegerMap = new HashMap<>();
        // Помещаем товары в Map, изначально чоличество товаров каждого вида равно 0
        for (var i : productList) {
            productIntegerMap.put(i, 0);
        }

        File file1 = new File("ProductFromSellerInput.xml");
        ProductFromSellerFileParser pfsfp = new ProductFromSellerFileParser();
        List<ProductFromSeller> productFromSellerList = pfsfp.inputFromFile(file1);
        // Товары считаются одинвковыми, если их ID совпадают,
        // Поэтому создаём временный товар с необходимым ID
        for (var i : productFromSellerList) {
            Product tmp = new Product(i.getProductID(), "tmp");
            productIntegerMap.put(new Product(tmp), productIntegerMap.get(tmp) + i.getNumber());
        }

        for (var product : productList) {
            System.out.printf("ID: %d, NAME: %s, NUMBER: %d %n", product.getProductID(), product.getProductName(), productIntegerMap.get(product));
        }
    }
}
