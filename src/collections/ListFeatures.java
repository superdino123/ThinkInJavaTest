package collections;

import java.util.List;
import java.util.Random;

import typeinfo.Hamster;
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
		System.out.println("3: " + pets.contains(h));
		
	}
}
