package xml;

import java.util.ArrayList;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Elements;

public class People extends ArrayList<Person> {
	public People(String fileName) throws Exception{
		Document doc = new Builder().build(fileName);
		Elements elements = doc.getRootElement().getChildElements();
		for(int i = 0; i < elements.size(); i++) {
			add(new Person(elements.get(i)));
		}
	}
	public static void main(String[] args) throws Exception{
		People p = new People("G:/10TomCat/apache-tomcat-8.5.31/webapps/ThinkInJavaTest/src/xml/People.xml");
		System.out.println(p);
	}
}
