package com.example.demo.form;

/**
 * 課題2の価格入力用フォーム.
 * 
 * @author hiroto.kitamura
 *
 */
public class PriceForm {
	/**
	 * 価格.
	 */
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PriceForm [price=" + price + "]";
	}

}
