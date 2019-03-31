package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipCompress {
	public static void main(String[] args) throws IOException {
		args = new String[] {
			"G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/ZipCompress.java"
		};
		FileOutputStream f = new FileOutputStream("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/test.zip");
		CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
		ZipOutputStream zos = new ZipOutputStream(csum);
		BufferedOutputStream out = new BufferedOutputStream(zos);
		zos.setComment("A test of Java Zipping");
		for(String arg : args) {
			System.out.print("Writing file " + arg);
			BufferedReader in = new BufferedReader(new FileReader(arg));
			zos.putNextEntry(new ZipEntry(arg));
			int c;
			while((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.flush();
		}
		out.close();
		System.out.println("Checksum: " + csum.getChecksum().getValue());
		System.out.println("Reading file");
		FileInputStream fi = new FileInputStream("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/test.zip");
		CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
		ZipInputStream in2 = new ZipInputStream(csumi);
		BufferedInputStream bis = new BufferedInputStream(in2);
		ZipEntry ze;
		while((ze = in2.getNextEntry()) != null) {
			System.out.println("Reading file " + ze);
			int x;
			while((x = bis.read()) != -1)
				System.out.write(x);
		}
		if(args.length == 1)
			System.out.println("Checksum: " + csumi.getChecksum().getValue());
		bis.close();
		ZipFile zf = new ZipFile("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/test.zip");
		Enumeration e = zf.entries();
		while(e.hasMoreElements()) {
			ZipEntry ze2 = (ZipEntry)e.nextElement();
			System.out.println("File: " + ze2);
		}
	}
}
