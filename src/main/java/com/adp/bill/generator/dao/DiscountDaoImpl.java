package com.adp.bill.generator.dao;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import com.adp.bill.generator.exception.BillingBusinessException;
import com.adp.bill.generator.exception.BillingTechnicalException;
import com.adp.bill.generator.utils.XmlConstants.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class DiscountDaoImpl implements DiscountDao {

	private static String fileName = "discount-slab.xml";
	private static ClassLoader classLoader = DiscountDaoImpl.class.getClassLoader();

	@Override
	public float getDiscountOnSlab(int totalBill) throws BillingTechnicalException, BillingBusinessException{

		float discount=0.0f;

		try{
			File inputFile = new File(classLoader.getResource(fileName).getFile());

			if(null == inputFile || inputFile.exists() == false)
				throw new BillingTechnicalException("File ["+fileName+"] does not exist.");

			SAXReader reader = new SAXReader();
			Document document = reader.read( inputFile );

			String xpathForSlab = "/"+DiscountSlabEnum.ROOT_TAG.getValue()+"/"
					+DiscountSlabEnum.SLAB.getValue()
					+"["
					+DiscountSlabEnum.RANGE_MIN.getValue()+"<="+totalBill
					+" and ("+DiscountSlabEnum.RANGE_MAX.getValue()+">="+totalBill
					+" or count("+DiscountSlabEnum.RANGE_MAX.getValue()+"[not(text())])>0 )"
					+"]"; 

			List<Node> nodes = document.selectNodes(xpathForSlab);

			List<Float> items = nodes.stream()
					.map(node -> Float.parseFloat(node.selectSingleNode(DiscountSlabEnum.DISCOUNT_PERCENTAGE.getValue()).getText()))
					.collect(Collectors.toList());

			if(items == null || items.size()==0)
				throw new BillingBusinessException("No discounted category found for totalBillAmount="+totalBill);

			discount = items.get(0);

		}catch(DocumentException de) {
			throw new BillingTechnicalException("Error while parsing the file["+fileName+"].", de);
		}

		return discount;
	}

}
