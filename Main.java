
public class Main {

	public static void main(String [] args){
		
		Tree<Person> t=new Tree<Person>();
		t.add(new Person(11));
		t.add(new Person(21));
		t.add(new Person(13));
		t.add(new Person(9));
		t.add(new Person(1));

		
		
		System.out.println(t);
		boolean b=t.contains(new Person(15));
		System.out.println(Boolean.toString(b));
		
		System.out.println(t.depth());
		
		System.out.println(t.numberOfLeafs());
		
	}
	
}
