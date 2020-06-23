package com.example.demo.constant;

public enum Colors {
	red("赤"), blue("青"), white("白"), yellow("黄");

	private final String name;

	private Colors(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
