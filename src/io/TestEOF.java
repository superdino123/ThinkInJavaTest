package io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {

	public static void main(String[] args) throws IOException {
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/TestEOF.java")));
		while(in.available() != 0)
			System.out.println((char)in.readByte());
	}
}
