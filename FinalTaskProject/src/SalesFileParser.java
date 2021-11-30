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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, реализующий функции для чтения и записи данных класса Sales
 * @see Sales
 */
public class SalesFileParser {
    /**
     * Функци чтения списка объектов класса Sales из файла
     * @param file - файл для чтения
     * @return список объектов класса Sales
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public List<Sales> inputFromFile(File file) throws ParserConfigurationException, IOException, SAXException {
        List<Sales> salesList = new ArrayList<Sales>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        Element root = document.getDocumentElement();
        NodeList children = root.getChildNodes();
        for (int i = 0; i < children.getLength(); i++){
            Node child = children.item(i);

            if (child instanceof Element) {
                Element childElement = (Element) child;
                int salesID = Integer.valueOf(childElement.getAttribute("salesID"));
                int sellerID = Integer.valueOf(childElement.getAttribute("sellerID"));
                int productID = Integer.valueOf(childElement.getAttribute("productID"));
                int numberOfProduct = Integer.valueOf(childElement.getAttribute("numberOfProduct"));

                String[] tmp = childElement.getAttribute("salesDate").split(":");
                LocalDate saleDate = LocalDate.of(Integer.valueOf(tmp[2]), Integer.valueOf(tmp[1]), Integer.valueOf(tmp[0]));

                salesList.add(new Sales(salesID, sellerID, productID, numberOfProduct, saleDate));
            }
        }

        return salesList;
    }
}
