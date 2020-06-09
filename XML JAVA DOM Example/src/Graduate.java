public  class Graduate extends Student  {
	private int GraduationYear;
	public Graduate(String name, int age, char gender) {
		super.name = name;
		super.age = age;
		super.gender = gender;
	}
	public Graduate(Student s) {
		super.name = s.getName();
		super.age = s.getAge();
		super.gender = s.getGender();
		super.major = s.getMajor();
	}
	public Graduate() {
		super();
	}
	public Graduate(String name, int age, char gender, String major) {
		super(name, age, gender, major);
	}
	public int getGraduationYear() {
		return GraduationYear;
	}
	public void setGraduationYear(String year) {
		this.GraduationYear = Integer.parseInt(year);
	}
	@Override
	public String toString() {
		return  super.toString() + ", gaduation year=" + GraduationYear;
	}
	@Override
	public final boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}