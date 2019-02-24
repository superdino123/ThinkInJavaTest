package typeinfo;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
	private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
	private static String[] typeNames = {
			"typeinfo.Mutt",
			"typeinfo.Pug",
			"typeinfo.EgyptianMau",
			"typeinfo.Manx",
			"typeinfo.Cymric",
			"typeinfo.Rat",
			"typeinfo.Mouse",
			"typeinfo.Hamster"
	};
	@SuppressWarnings("unchecked")
	private static void loader() {
		try {
			for(String name : typeNames)
				types.add(
						(Class<? extends Pet>)Class.forName(name));
		} catch(ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	static { loader(); }
	public List<Class<? extends Pet>> types(){ return types; }
}
