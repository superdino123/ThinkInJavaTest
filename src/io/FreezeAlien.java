package io;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class FreezeAlien {
	public static void main(String[] args) throws Exception{
		ObjectOutput out = new ObjectOutputStream(
				new FileOutputStream("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/X.file"));
		Alien quellek = new Alien();
		out.writeObject(quellek);
	}
}
