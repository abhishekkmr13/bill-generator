package com.adp.bill.generator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import com.adp.bill.generator.entities.Item;
import com.adp.bill.generator.entities.ShoppingCart;
import com.adp.bill.generator.service.Checkout;
import com.adp.bill.generator.service.DiscountedCheckout;
import com.adp.bill.generator.service.ShoppingCartService;
import com.adp.bill.generator.service.ShoppingCartServiceImpl;
import com.adp.bill.generator.vo.BillingDetailDVO;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;

public class ShoppingCartBillingMain {

	public static void main(String[] args) {

		try {
			String[] columns = {"id","item_name","unit_price","quantity","discount","final_price"};

			ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();
			List<Item> items = shoppingCartService.getAllItems();

			Checkout<ShoppingCart, BillingDetailDVO> checkout = new DiscountedCheckout();

			BillingDetailDVO billingDetailDVO = checkout.calculateTotal(new ShoppingCart(items));

			JasperReportBuilder report = DynamicReports.report();

			report
			.columns(
					Columns.column("Item Id", "id", DataTypes.stringType()),
					Columns.column("Item Name", "item_name", DataTypes.stringType()),
					Columns.column("Unit Price", "unit_price", DataTypes.stringType()),
					Columns.column("Quantity", "quantity", DataTypes.stringType()),
					Columns.column("Discount(%)", "discount", DataTypes.stringType()),
					Columns.column("Final Price", "final_price", DataTypes.stringType()))
			.title(//title of the report
					Components.text("Shopping Cart Bill")
					.setHorizontalAlignment(HorizontalAlignment.CENTER))
			.pageFooter(Components.pageXofY());

			DRDataSource dataSource = new DRDataSource(columns);

			DecimalFormat decimalformat = new DecimalFormat();
			decimalformat.setMaximumFractionDigits(2);

			billingDetailDVO.getBilledItem().forEach(billedItem ->{
				Object[] rowArray =  new Object[columns.length];
				Item item = billedItem.getItem();
				rowArray[0]=new Integer(item.getId()).toString();
				rowArray[1]=item.getItemName();
				rowArray[2]=new Float(item.getUnitPrice()).toString();
				rowArray[3]=new Integer(item.getQuantity()).toString();
				rowArray[4]=new Float(billedItem.getDiscount()).toString();
				rowArray[5]=decimalformat.format((billedItem.getFinalPrice()*100.00)/100.00);

				dataSource.add(rowArray);

			});

			Object[] summaryArray =  new Object[columns.length];
			summaryArray[4]="Total";
			summaryArray[5]=decimalformat.format((billingDetailDVO.getAmountBeforeDiscount()*100.00)/100.00);
			dataSource.add(summaryArray);

			Object[] slabDiscountArray =  new Object[columns.length];
			slabDiscountArray[4]="Additional Discount(%)";
			slabDiscountArray[5]=decimalformat.format(billingDetailDVO.getSlabDiscount());
			dataSource.add(slabDiscountArray);


			Object[] payableArray =  new Object[columns.length];
			payableArray[4]="Payable Amount";
			payableArray[5]=decimalformat.format((billingDetailDVO.getAmountAfterDiscount()*100.00)/100.00);
			dataSource.add(payableArray);


			try {
				report.setDataSource(dataSource);
				//show the report
				report.show();

			} catch (DRException e) {
				e.printStackTrace();
			} 
		}catch(Exception exc) {
			System.err.println("Failed to generate bill, please try after sometime. Cause="+exc.getMessage());
		}

	}

}
