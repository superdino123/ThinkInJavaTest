package collections;

import java.util.Iterator;
import java.util.List;

import typeinfo.Pet;
import typeinfo.Pets;
// 通过迭代器，不必关心实际应用的列表类型
public class SimpleIteraion {
	public static void main(String[] args) {
		List<Pet> pets = Pets.arrayList(12);
		Iterator<Pet> it = pets.iterator();
		while(it.hasNext()) {
			Pet p = it.next();
			System.out.println(p.id() + ": " + p + " ");
		}
		System.out.println();
		for(Pet p : pets) {
			System.out.println(p.id() + ": " + p + " ");
		}
		System.out.println();
		it = pets.iterator();
		for(int i = 0; i < 6; i++) {
			it.next();
			it.remove();
		}
		System.out.println(pets);
	}
}
