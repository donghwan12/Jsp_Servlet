package C08;

public class Person {
	private String name;
	private int age;
	private String addr;
	
	//Getter and Setter
	//생성자
	//toString
	public Person() {}
	
	
	public Person(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	//
	//
	//
	
	
}
