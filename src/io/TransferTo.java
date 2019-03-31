package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class TransferTo {
	public static void main(String[] args) throws Exception{

		args = new String[] {"G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/data2.txt",
		        "G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/data3.txt"};
		if(args.length != 2) {
			System.out.println("arguments: sourcefile destfile");
			System.exit(1);
		}
		FileChannel in = new FileInputStream(args[0]).getChannel();
		FileChannel out = new FileOutputStream(args[1]).getChannel();
		in.transferTo(0, in.size(), out);
	}
}
