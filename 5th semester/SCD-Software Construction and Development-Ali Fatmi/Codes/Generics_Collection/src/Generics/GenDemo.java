package Generics;

public class GenDemo {

	public static void main(String[] args) {
		
		Gen<Integer> iOb;
		
		iOb = new Gen<Integer>(99);
		iOb.showType();
		
		int i = iOb.getObj();
		
		System.out.println("Int Val got from iob object: " + i);
		
		Gen<String> strOb = new Gen<String>("string");
		strOb.showType();
		
		String s = strOb.getObj();
		
		System.out.println("String Val got from strobject: " + s);

		//iOb = strOb
		
		
		Gen2Var<Integer, String> strint = new Gen2Var<Integer, String>(99, "String");
		strint.showType();
		
		Bounded<Integer> in = new Bounded<Integer>(19);
		in.showType();
		
		Bounded<Float> fl = new Bounded<Float>((float)9.999);
		fl.showType();
		
		Bounded<Double> db = new Bounded<Double>(9.999);
		db.showType();
		
		// Bounded<String> st = new Bounded<String>("str");
//		st.showType();
	}

}
