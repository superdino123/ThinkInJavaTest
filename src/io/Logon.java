package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Logon implements Serializable {
	private Date date = new Date();
	private String username;
	private transient String password;
	public Logon(String name, String pwd) {
		username = name;
		password = pwd;
	}
	public String toString() {
		return "logon info: \n username: " + username + 
				"\n date: " + date + "\n password: " + password;
	}
	public static void main(String[] args) throws Exception{
		Logon a = new Logon("Hulk", "myLittlePony");
		System.out.println("logon a = " + a);
		ObjectOutputStream o = new ObjectOutputStream(
				new FileOutputStream("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/Logon.out"));
		o.writeObject(a);
		o.close();
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/io/Logon.out"));
		System.out.println("Recovering object at " + new Date());
		a = (Logon)in.readObject();
		System.out.println("logon a = " + a);
	}
}
