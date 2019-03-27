package io;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
	public static void main(String[] args) throws IOException {
		StringReader in = new StringReader(
				BufferedInputFile.read("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/MemoryInput.java"));
		int c;
		//read()以int形式返回一个字节，必须进行类型转换
		while((c = in.read()) != -1)
			System.out.println((char)c);
	}
}
