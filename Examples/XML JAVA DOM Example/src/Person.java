

/**
 * This is an instantiable class that contains fields about a Person
 * @author rryon
 *
 */
public  class Person {
	
	protected String name;
	
	protected int age;
	
	protected char gender;
	
	/**
	 * Constructor using fields
	 * @param name
	 * @param age
	 * @param gender
	 */
	public Person(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	/**
	 * Default Constructor
	 */
	public Person() {
		super();
		this.name = "Not assigned";
		this.age = 0;
		gender = 'U';
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.trim().equals(""))
			throw new RuntimeException("Invalid name, shouldn't be blank.");
		if (name.trim().length()>25)
			throw new RuntimeException("Invalid name, length is too long.");
		this.name = name.trim();
	}
	public int getAge() {
		
		return age;
	}
	public void setAge(int age) {
		if(age < 0)
			throw new RuntimeException("Invalid age; cannot be negative.");
		this.age = age;
	}
	public void setAge(String age) {
		int tempAge;
		try {
			tempAge = Integer.parseInt(age);
			setAge(tempAge);
		}
		catch(NumberFormatException e) {
			throw new RuntimeException("Invalid age; Non numeric.");
		}
		

		
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		
		this.gender = gender;
	}
	public void setGender(String input) {
		// TODO Auto-generated method stub
		
	}	
	@Override
	public String toString() {
		return "name=" + name + ", age=" + age + ", gender=" + gender;
	}


	

	
}








