package com.adp.bill.generator.dao;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXParseException;

import com.adp.bill.generator.entities.Category;
import com.adp.bill.generator.exception.BillingBusinessException;
import com.adp.bill.generator.exception.BillingTechnicalException;
import com.adp.bill.generator.utils.XmlConstants.CategoryEnum;

public class CategoryDaoImpl implements CategoryDao{

	private static String fileName = "categories.xml";
	private static ClassLoader classLoader = CategoryDaoImpl.class.getClassLoader();


	public Category getCategory(int categoryId) throws BillingTechnicalException, BillingBusinessException {

		Category category = null;

		try{
			File inputFile = new File(classLoader.getResource(fileName).getFile());

			if(null == inputFile || inputFile.exists() == false)
				throw new BillingTechnicalException("File ["+fileName+"] does not exist.");

			SAXReader reader = new SAXReader();
			Document document = reader.read( inputFile );

			String categoryXpath = "/"+CategoryEnum.CATEGORIES.getValue()+"/"+CategoryEnum.CATEGORY.getValue()+"[id = '00"+categoryId+"']" ;
			List<Node> nodes = document.selectNodes(categoryXpath);

			List<Category> categories = nodes.stream()
					.map(node -> new Category(Integer.parseInt(node.selectSingleNode(CategoryEnum.ID.getValue()).getText()),
							node.selectSingleNode(CategoryEnum.NAME.getValue()).getText(), 
							Float.parseFloat(node.selectSingleNode(CategoryEnum.DISCPERC.getValue()).getText())))
					.collect(Collectors.toList());
			
			if(categories == null || categories.size()==0)
				throw new BillingBusinessException("No category found with categoryID="+categoryId);

			category = categories.get(0);

		}catch(DocumentException de) {
			throw new BillingTechnicalException("Error while parsing the file["+fileName+"].", de);
		}

		return category;
	}


}
