package io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {
	
	public static void main(String[] args) throws IOException {
		try {
			DataInputStream in = new DataInputStream(new ByteArrayInputStream(
					BufferedInputFile.read("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/FormattedMemoryInput.java").getBytes()));
			while(true)
				System.out.println((char)in.readByte());
		} catch(EOFException e) {
			System.err.println("End of stream");
		}
	}
}
