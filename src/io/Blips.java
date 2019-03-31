package io;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Blip1 implements Externalizable{
	public Blip1() {
		System.out.print("Blip1 Constructor");
	}
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip1.writeExternal");
	}
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException{
		System.out.print("Blip1.readExtenal");
	}
}

class Blip2 implements Externalizable{
	Blip2(){
		System.out.println("Blip2.Constructor");
	}
	public void writeExternal(ObjectOutput out) throws IOException{
		System.out.println("Blip2.writeExternal");
	}
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException{
		System.out.print("Blip2.readExtenal");
	}
}

public class Blips {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("Constructing objects: ");
		Blip1 b1 = new Blip1();
		Blip2 b2 = new Blip2();
		ObjectOutputStream o = new ObjectOutputStream(
				new FileOutputStream("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/Blips.out"));
		System.out.println("Saving objects:");
		o.writeObject(b1);
		o.writeObject(b2);
		o.close();
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/Blips.out"));
		System.out.println("Recovering b1:");
		b1 = (Blip1)in.readObject();
	}
}