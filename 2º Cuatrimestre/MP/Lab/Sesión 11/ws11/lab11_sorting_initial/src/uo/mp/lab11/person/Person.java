package uo.mp.lab11.person;

public class Person implements Comparable<Person> {
	private String name;
	private String surname;
	private int age;

	public Person(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	@Override
	public String toString() {
		return name + " " + surname;
	}

	@Override
	public int compareTo(Person that) {
//		if (this.getAge() == that.getAge()) {
//			return 0;
//		}
//		else if (this.getAge() == that.getAge()) {
//			return 1;
//		}
//		else {
//			return -1;
//		}

//		return this.getAge() - that.getAge();	//se suele hacer así

		
		
		if (this.getAge() == that.getAge()) {
			if (this.getSurname().compareTo(that.getSurname()) == 0) {
				return this.getName().compareTo(getName());
			} else {
				return this.getSurname().compareTo(that.getSurname());
			}
		} else {
			return this.getAge() - that.getAge();
		}

//		int dif = this.getAge() - that.getAge();
//		dif = dif == 0 ? this.getSurname().compareTo( that.getSurname() ) : dif;
//		dif = dif == 0 ? this.getName().compareTo( that.getName() ): dif;
//	
//		return dif;
	}

}