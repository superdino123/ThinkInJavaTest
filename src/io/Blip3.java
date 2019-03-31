package io;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Blip3 implements Externalizable {
	private int i;
	private String s;
	public Blip3() {
		System.out.println("Blip3 Constructor");
	}
	public Blip3(String x, int a) {
		System.out.println("Blip3(String x, int a)");
		s = x;
		i = a;
	}
	public String toString() {
		return s + i;
	}
	public void writeExternal(ObjectOutput out) throws IOException{
		System.out.println("Blip3.writeExternal");
		
		out.writeObject(s);
		out.writeInt(i);
	}
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException{
		System.out.println("Blip3.readExternal");
		
		s = (String)in.readObject();
		i = in.readInt();
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		System.out.println("Constructing objects: ");
		Blip3 b3 = new Blip3("A String", 47);
		System.out.println(b3);
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/Blip3.out"));
		System.out.println("Saving object: ");
		o.writeObject(b3);
		o.close();
		
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/Blip3.out"));
		System.out.println("Recoving b3: ");
		b3 = (Blip3)in.readObject();
		System.out.println(b3);
	}
}
