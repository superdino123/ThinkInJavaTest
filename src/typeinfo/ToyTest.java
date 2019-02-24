package typeinfo;

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

class Toy{
	Toy(){}
	Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots{
	FancyToy(){ super(1); }
}

public class ToyTest {
	static void printInfo(Class cc) {
		System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
		System.out.println("Simple name: " + cc.getSimpleName());
		System.out.println("Canonical name: " + cc.getCanonicalName());
	}
	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("typeinfo.FancyToy");
		} catch (ClassNotFoundException e){
			System.out.println("Can't find FancyToy");
			System.exit(1);
		}
		System.out.println("printInfo");
		printInfo(c);
		System.out.println("face");
		for(Class face: c.getInterfaces())
			printInfo(face);

		System.out.println("superclass");
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance();
		} catch (InstantiationException e) {
			System.out.println("Cannot instantiate");
			System.exit(1);
		} catch(IllegalAccessException e) {
			System.out.println("Cannot access");
			System.exit(1);
		}
		printInfo(obj.getClass());
	}
}/* Output:
printInfo
Class name: typeinfo.FancyToy is interface? [false]
Simple name: FancyToy
Canonical name: typeinfo.FancyToy
face
Class name: typeinfo.HasBatteries is interface? [true]
Simple name: HasBatteries
Canonical name: typeinfo.HasBatteries
Class name: typeinfo.Waterproof is interface? [true]
Simple name: Waterproof
Canonical name: typeinfo.Waterproof
Class name: typeinfo.Shoots is interface? [true]
Simple name: Shoots
Canonical name: typeinfo.Shoots
superclass
Class name: typeinfo.Toy is interface? [false]
Simple name: Toy
Canonical name: typeinfo.Toy
*///:~
