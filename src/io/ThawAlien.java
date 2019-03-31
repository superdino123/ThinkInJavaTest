package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ThawAlien {
	public static void main(String[] args) throws Exception{
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(new File("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/", "X.file")));
		Object mystery = in.readObject();
		System.out.println(mystery.getClass());
	}
}
