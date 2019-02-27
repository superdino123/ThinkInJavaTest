package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import typeinfo.Cymric;
import typeinfo.Hamster;
import typeinfo.Mouse;
import typeinfo.Pet;
import typeinfo.Pets;

public class ListFeatures {
	public static void main(String[] args) {
		Random rand = new Random(47);
		List<Pet> pets = Pets.arrayList(7);
		System.out.println("1: " + pets);
		Hamster h = new Hamster();
		pets.add(h);
		System.out.println("2: " + pets);
		//判断某个对象是否在列表中
		System.out.println("3: " + pets.contains(h));
		pets.remove(h);
		Pet p = pets.get(2);
		//对象在list中的索引位置
		System.out.println("4: " + p + " " + pets.indexOf(p));
		Pet cymric = new Cymric();
		System.out.println("5: " + pets.indexOf(cymric));
		//移除对象
		System.out.println("6: " + pets.remove(cymric));
		System.out.println("7: " + pets.remove(p));
		System.out.println("8: " + pets);
		pets.add(3, new Mouse());
		System.out.println("9: " + pets);
		//允许你很容易地从较大的列表中创建出一个片断
		List<Pet> sub = pets.subList(1, 4);
		System.out.println("subList:" + sub);
		//有效的"交集"操作
		System.out.println("10: " + pets.containsAll(sub));
		Collections.sort(sub);
		System.out.println("sorted subList: " + sub);
		System.out.println("11 " + pets.containsAll(sub));
		Collections.shuffle(sub, rand);
		System.out.println("shuffled subList: " + sub);
		System.out.println("12: " + pets.containsAll(sub));
		List<Pet> copy = new ArrayList<Pet>(pets);
		sub = Arrays.asList(pets.get(1), pets.get(4));
		System.out.println("sub: " + sub);
		copy.retainAll(sub);
		System.out.println("13: " + copy);
		copy = new ArrayList<Pet>(pets);
		copy.remove(2);
		System.out.println("14: " + copy);
		//移除所有元素
		copy.removeAll(sub);
		System.out.println("15: " + copy);
		copy.set(1, new Pet());
		System.out.println("16: " + copy);
		copy.addAll(2, sub);
		System.out.println("17: " + copy);
		System.out.println("18: " + pets.isEmpty());
		pets.clear();
		System.out.println("19: " + pets);
		System.out.println("20: " + pets.isEmpty());
		pets.addAll(Pets.arrayList(4));
		System.out.println("21: " + pets);
		Object[] o = pets.toArray();
		System.out.println("22: " + o[3]);
		Pet[] pa = pets.toArray(new Pet[0]);
		System.out.println("23: " + pa[3].id());		
	}
}
