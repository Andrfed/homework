import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, реализующий функции для чтения и записи данных класса ProductFromSeller
 * @see ProductFromSeller
 */
public class ProductFromSellerFileParser {
    /**
     * Функци чтения списка объектов класса ProductFromSeller из файла
     * @param file - файл для чтения
     * @return список объектов класса ProductFromSeller
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public List<ProductFromSeller> inputFromFile(File file) throws ParserConfigurationException, IOException, SAXException {
        List<ProductFromSeller> productFromSellerList = new ArrayList<ProductFromSeller>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        Element root = document.getDocumentElement();
        NodeList children = root.getChildNodes();
        for (int i = 0; i < children.getLength(); i++){
            Node child = children.item(i);

            if (child instanceof Element) {
                Element childElement = (Element) child;
                int sellerID = Integer.valueOf(childElement.getAttribute("sellerID"));
                int productID = Integer.valueOf(childElement.getAttribute("productID"));
                int productCost = Integer.valueOf(childElement.getAttribute("productCost"));
                int productNumber = Integer.valueOf(childElement.getAttribute("productNumber"));

                productFromSellerList.add(new ProductFromSeller(sellerID, productID, productCost, productNumber));
            }
        }

        return productFromSellerList;
    }
}
