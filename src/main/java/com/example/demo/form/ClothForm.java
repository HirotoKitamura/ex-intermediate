package com.example.demo.form;

/**
 * 衣服のフォーム.
 * 
 * @author hiroto.kitamura
 *
 */
public class ClothForm {
	/**
	 * 色.
	 */
	private String color;
	/**
	 * 性別.
	 * 
	 * 男性が0で女性が1
	 */
	private Integer gender;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "ClothForm [color=" + color + ", gender=" + gender + "]";
	}

}
