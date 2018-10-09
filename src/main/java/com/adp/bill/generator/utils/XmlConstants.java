package com.adp.bill.generator.utils;

public class XmlConstants {


	public enum CategoryEnum {

		CATEGORIES("Categories"),
		CATEGORY("Category"),
		ID("id"),
		NAME("name"),
		DISCPERC("discPerc");


		/** The value. */
		private String value;


		private CategoryEnum(String value) {

			this.value = value;
		}

		public String getValue() {

			return value;
		}

	}

	public enum ShoppingCartEnum {

		SHOPPING_CART("ShoppingCart"),
		ITEM("item"),
		ITEM_ID("itemID"),
		ITEM_CATEGORY_ID("itemCategoryID"),
		ITEM_NAME("itemName"),
		UNIT_PRICE("unitPrice"),
		QUANTITY("quantity");


		/** The value. */
		private String value;


		private ShoppingCartEnum(String value) {

			this.value = value;
		}

		public String getValue() {

			return value;
		}

	}
	
	public enum DiscountSlabEnum {

		ROOT_TAG("FlatDiscountSlabs"),
		SLAB("Slab"),
		RANGE_MIN("RangeMin"),
		RANGE_MAX("RangeMax"),
		DISCOUNT_PERCENTAGE("discPerc");


		/** The value. */
		private String value;


		private DiscountSlabEnum(String value) {

			this.value = value;
		}

		public String getValue() {

			return value;
		}

	}
}
