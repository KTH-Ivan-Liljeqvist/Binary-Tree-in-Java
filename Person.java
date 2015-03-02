
public class Person implements Comparable<Person>{

	private int age;
	
	public Person(int a){
		this.age=a;
	}
	
	public int compareTo(Person p) {
		if(age<p.age){
			return -1;
		}
		else if(age==p.age){
			return 0;
		}
		else{
			return 1;
		}
	}
	
	public String toString(){
		return Integer.toString(age);
		
	}

}
