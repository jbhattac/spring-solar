package com.jb.springsolar;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		String text = "The quick brown fox jumps over the lazy dog";
		String ran = "visa";
		text.isEmpty();
		Set<Character> textList = new LinkedHashSet(text.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList()));
		Set <Character> ranList =  new LinkedHashSet(ran.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList()));
		if(textList.equals(ranList)) System.out.println("y");
	}

}
