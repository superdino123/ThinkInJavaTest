package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
	private static final int BSIZE = 1024;
	public static void main(String[] arga) throws Exception{
		
		FileChannel fc = new FileOutputStream("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/data1.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text ".getBytes()));
		fc.close();
		fc = new RandomAccessFile("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/data1.txt", "rw").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap("Some more".getBytes()));
		fc.close();
		fc = new FileInputStream("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/data1.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		while(buff.hasRemaining())
			System.out.print((char)buff.get());
	}
}
