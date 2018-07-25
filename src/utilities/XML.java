package utilities;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XML {

	// Returns a double array from an XML file
	public static String[][] getShoppingCart(String file){
		//1. Create the file
		
		InputSource xmlFile = new InputSource(file);
		
		
		//2. Prepare XPath
		XPathFactory xpf = XPathFactory.newInstance();
		XPath xPath = xpf.newXPath();
		
		
		
		try {
			//3. Define node settings
			NodeList xOrders = (NodeList) xPath.evaluate("/shopppingcart/order", xmlFile, XPathConstants.NODE);
			XPathExpression xItemResult = xPath.compile("itemresult");
			
			//4. Iterate through XML
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		//5. Close the file
		
		return null;
	}
	
}
