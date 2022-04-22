package com.jb.springsolar;

public class Sub extends Super {
	
	public void print(String name) {
		super.print(name);
		System.out.println("Sub Hello : "+ name);
	}

}
