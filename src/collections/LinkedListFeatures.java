package collections;

import java.util.LinkedList;
import typeinfo.Hamster;
import typeinfo.Pet;
import typeinfo.Pets;
import typeinfo.Rat;

public class LinkedListFeatures {
	public static void main(String[] args) {
		LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(5));
		System.out.println(pets);
		//获取列表头元素，peek在列表为空时返回null
		System.out.println("pets.getFirst(): " + pets.getFirst());
		System.out.println("pets.element(): " + pets.element());
		System.out.println("pets.peek(): " + pets.peek());
		//移除列表头元素，poll在列表为空时返回null
		System.out.println("pets.remove(): " + pets.remove());
		System.out.println("pets.removeFirst(): " + pets.removeFirst());
		System.out.println("pets.poll(): " + pets.poll());
		System.out.println(pets);
		//插入元素
		pets.addFirst(new Rat());
		System.out.println("After addFirst(): " + pets);
		pets.offer(Pets.randomPet());
		System.out.println("After offer(): " + pets);
		pets.offer(Pets.randomPet());
		System.out.println("After add(): " + pets);
		pets.offer(new Hamster());
		System.out.println("After addLast(): " + pets);
		System.out.println("pets.removeLast(): " + pets.removeLast());
	}
}
