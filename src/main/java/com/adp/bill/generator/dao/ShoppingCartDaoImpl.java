package com.adp.bill.generator.dao;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.adp.bill.generator.entities.Category;
import com.adp.bill.generator.entities.Item;
import com.adp.bill.generator.exception.BillingBusinessException;
import com.adp.bill.generator.exception.BillingTechnicalException;
import com.adp.bill.generator.utils.XmlConstants.*;

public class ShoppingCartDaoImpl implements ShoppingCartDao {

	private static String fileName = "sample-shopping-cart1.xml";
	private static ClassLoader classLoader = CategoryDaoImpl.class.getClassLoader();
	
	@Override
	public void addItemToShoppingCart(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItemFromShoppingCart(Item item, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Item> getAllItems() throws BillingTechnicalException, BillingBusinessException{

		try{
			File inputFile = new File(classLoader.getResource(fileName).getFile());
			
			if(null == inputFile || inputFile.exists() == false)
				throw new BillingTechnicalException("File ["+fileName+"] does not exist.");
			
			SAXReader reader = new SAXReader();
			Document document = reader.read( inputFile );

			List<Node> nodes = document.selectNodes("/ShoppingCart/item" );
			
			List<Item> items = nodes.stream()
									.map(node -> new Item(Integer.parseInt(node.selectSingleNode(ShoppingCartEnum.ITEM_ID.getValue()).getText()),
											new Category(Integer.parseInt(node.selectSingleNode(ShoppingCartEnum.ITEM_CATEGORY_ID.getValue()).getText())),
											node.selectSingleNode(ShoppingCartEnum.ITEM_NAME.getValue()).getText(),
											Float.parseFloat(node.selectSingleNode(ShoppingCartEnum.UNIT_PRICE.getValue()).getText()),
											Integer.parseInt(node.selectSingleNode(ShoppingCartEnum.QUANTITY.getValue()).getText())))
											.collect(Collectors.toList());
			
			return items;
		}catch(DocumentException de) {
			throw new BillingTechnicalException("Error while parsing the file["+fileName+"].", de);
		}
	}
	
}
