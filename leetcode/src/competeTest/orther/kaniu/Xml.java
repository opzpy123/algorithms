package competeTest.orther.kaniu;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class Xml {
	public static void main(String[] args) {
		createXml();
	}

	public static void createXml() {
		try {
			// 创建解析器工厂
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = factory.newDocumentBuilder();
			Document document = db.newDocument();
			// 不显示standalone="no"
			document.setXmlStandalone(true);


			//创建根目录
			Element CategoryList = document.createElement("CategoryList");

			// 向CategoryList根节点中添加子节点Category
			Element Category = document.createElement("Category");


			Element mainCategory = document.createElement("MainCategory");
			mainCategory.setTextContent("XML");
			Category.appendChild(mainCategory);

			Element description = document.createElement("Description");
			description.setTextContent("This is a list my XML articles.");
			Category.appendChild(description);

			Element active = document.createElement("Active");
			active.setTextContent("True");
			Category.appendChild(active);


			//设置子结点Category属性
			Category.setAttribute("ID", "01");
			// 将Category节点添加到CategoryList根节点中
			CategoryList.appendChild(Category);

			// 将CategoryList添加到dom树中
			document.appendChild(CategoryList);

			// 创建TransformerFactory对象
			TransformerFactory tff = TransformerFactory.newInstance();
			// 创建 Transformer对象
			Transformer tf = tff.newTransformer();

			// 输出内容是否使用换行
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			// xml文件输出到StringWriter
			StringWriter out = new StringWriter();
			tf.transform(new DOMSource(document), new StreamResult(out));
			System.out.println(out.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
