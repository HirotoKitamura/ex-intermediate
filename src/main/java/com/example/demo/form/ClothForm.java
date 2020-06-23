package com.example.demo.form;

import com.example.demo.constant.Colors;

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
	private Colors color;
	/**
	 * 性別.
	 * 
	 * 男性が0で女性が1
	 */
	private Integer gender;

	public Colors getColor() {
		return color;
	}

	public void setColor(Colors color) {
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
