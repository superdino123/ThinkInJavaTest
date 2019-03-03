package collections;

import java.util.HashMap;
import java.util.Map;

import typeinfo.Cat;
import typeinfo.Dog;
import typeinfo.Hamster;
import typeinfo.Pet;

public class PetMap {
	public static void  main(String[] args) {
		Map<String, Pet> petMap = new HashMap<String, Pet>();
		petMap.put("My Cat", new Cat("Molly"));
		petMap.put("My Dog", new Dog("Ginget"));
		petMap.put("My Hamster", new Hamster("Bosco"));
		System.out.println(petMap);
		Pet dog = petMap.get("My Dog");
		System.out.println(dog);
		System.out.println(petMap.containsKey("My Dog"));
		System.out.println(petMap.containsValue(dog));
	}
}/* Output:
{My Dog=Dog Ginget, My Cat=Cat Molly, My Hamster=Hamster Bosco}
Dog Ginget
true
true
*///:~
