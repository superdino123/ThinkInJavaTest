package io;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class LargeMappedFiles {
	
	static int length = 0x8FFFFFF;
	public static void main(String[] args) throws Exception{
		
		MappedByteBuffer out = new RandomAccessFile("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/test.dat", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
		for(int i = 0; i < length; i++)
			out.put((byte)'x');
		System.out.println("Finished writing");
		for(int i = length/2; i < length/2 + 6; i++)
			System.out.print((char)out.get(i));
	}
}
