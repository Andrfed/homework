import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.ls.LSException;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.w3c.dom.ls.LSSerializerFilter;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XMLStreamException {
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
        // Товары считаются одинaковыми, если их ID совпадают,
        // Поэтому создаём временный товар с необходимым ID
        for (var i : productFromSellerList) {
            Product tmp = new Product(i.getProductID(), "tmp");
            productIntegerMap.put(new Product(tmp), productIntegerMap.get(tmp) + i.getNumber());
        }
        // Записываем первый выходной файл
        File out1File = new File("out1.xml");
        XMLOutputFactory out1Factory = XMLOutputFactory.newInstance();
        Writer writerOut1 = new PrintWriter(out1File);
        XMLStreamWriter out1StreamWriter = out1Factory.createXMLStreamWriter(writerOut1);
        out1StreamWriter.writeStartDocument();
        out1StreamWriter.writeStartElement("productlist");
        for (var product : productList) {
            out1StreamWriter.writeStartElement("product");
            out1StreamWriter.writeAttribute("productID", String.format("%d", product.getProductID()));
            out1StreamWriter.writeAttribute("productName",  product.getProductName());
            out1StreamWriter.writeAttribute("numberOfProduct", productIntegerMap.get(product).toString());
            out1StreamWriter.writeEndElement();
        }
        out1StreamWriter.writeEndElement();
        out1StreamWriter.writeEndDocument();
        out1StreamWriter.close();

        SalesFileParser sfp = new SalesFileParser();
        File file2 = new File("SalesInput.xml");
        List<Sales> salesList = sfp.inputFromFile(file2);
        // Помещаем сумму количеств проданных продуктов в день в Map
        Map<LocalDate, Integer> datePruductNumber = new HashMap<>();
        // Помещаем количество продаж продуктов в день в Map
        Map<LocalDate, Integer> dateSalesNumber = new HashMap<>();
        for (var sale : salesList) {
            if (datePruductNumber.containsKey(sale.getSaleDate())) {
                datePruductNumber.replace(sale.getSaleDate(), sale.getNumberOfProduct() + datePruductNumber.get(sale.getSaleDate()));
            }
            else {
                datePruductNumber.put(sale.getSaleDate(), sale.getNumberOfProduct());
            }
            if (dateSalesNumber.containsKey(sale.getSaleDate())) {
                dateSalesNumber.replace(sale.getSaleDate(), 1 + datePruductNumber.get(sale.getSaleDate()));
            }
            else {
                dateSalesNumber.put(sale.getSaleDate(), 1);
            }
        }
        // Среднее для каждого дня = (сумма количеств / количество продаж)
        // Записываем второй выходной файл и вычисляем ответ
        File out2File = new File("out2.xml");
        XMLOutputFactory out2Factory = XMLOutputFactory.newInstance();
        Writer writerOut2 = new PrintWriter(out2File);
        XMLStreamWriter out2StreamWriter = out2Factory.createXMLStreamWriter(writerOut2);
        out2StreamWriter.writeStartDocument();
        out2StreamWriter.writeStartElement("datelist");
        for (var key : datePruductNumber.keySet()) {
            out2StreamWriter.writeStartElement("date");
            out2StreamWriter.writeAttribute("date", key.toString());
            out2StreamWriter.writeAttribute("average", String.format("%f", ((double)datePruductNumber.get(key)) / dateSalesNumber.get(key)) );
            out2StreamWriter.writeEndElement();
        }
        out2StreamWriter.writeEndElement();
        out2StreamWriter.writeEndDocument();
        out2StreamWriter.close();
    }
}
