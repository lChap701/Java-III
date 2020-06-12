public  class Student extends Person  {

    protected String major;

    public Student(String name, int age, char gender) {
        super.name = name;
        super.age = age;
        super.gender = gender;
    }

    public Student(Person p) {
        super.name = p.getName();
        super.age = p.getAge();
        super.gender = p.getGender();
    }

    public Student() {
        super();
    }

    public Student(String name, int age, char gender, String major) {
        super(name, age, gender);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return  super.toString() + ", major=" + major;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }



}
