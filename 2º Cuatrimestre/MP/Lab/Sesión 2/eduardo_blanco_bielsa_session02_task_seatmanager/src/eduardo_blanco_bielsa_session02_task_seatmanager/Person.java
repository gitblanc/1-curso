package eduardo_blanco_bielsa_session02_task_seatmanager;

public class Person {
	
	public final static double  MIN_AGE = 0;          // m�nimo de edad 
    public final static double MAX_AGE = 120; 
    public static final double ADULTHOOD_AGE = 18;     // mayor�a de edad
    public static final double RETIREMENT_AGE = 65;     // edad de jubilaci�n 


	private String name; // nombre de la persona
	private int age; // edad de la persona

	
	/**
	 * @param name edad de la persona
	 * @param age nombre de la persona
	 */
	public Person(String name, int age) {
		setName(name);
		setAge(age);
	}

	/**
	 * Modifica el valor del nombre de la persona
	 * 
	 * @param name el nuevo nombre que se le da a la persona
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Modifica el valor de la edad de la persona
	 * 
	 * @param age el nuevo valor que se le da a la edad
	 */
	public void setAge(int age) {
		if (age >= MIN_AGE && age < MAX_AGE)
			this.age = age;
	}

	/**
	 * Devuelve el nombre de la persona
	 */	
	public String getName() {
		return name;
	}

	/**
	 * Devuelve la edad de la persona
	 */	
	public int getAge() {
		return age;
	}

	/**
	 * Devuelve una cadena con los datos de la persona
	 *
	 * @return cadena con todos los propiedades de la persona
	 */
	public String toString() {
	  return "Nombre: " + getName().toUpperCase() + " Edad: " + getAge();				
	}

	/**
	 * Devuelve : 
	 *   Si la persona es menor de edad, los a�os que le
	 *     faltan hasta la mayor�a. 
	 *   Si la persona es mayor de edad pero menor de 65
	 *     los a�os que le faltan hasta 65 
	 *   Si la persona es mayor de 65 
	 *     los a�os que pasa de 65
	 *
	 * @return double cantidad de a�os
	 */
	public double getCriticalAge() {
		if (this.getAge() < ADULTHOOD_AGE)
			return ADULTHOOD_AGE - getAge();
		if (getAge() >= ADULTHOOD_AGE && getAge() < RETIREMENT_AGE)
			return RETIREMENT_AGE - getAge();
		else
			return getAge() - RETIREMENT_AGE;
	}	

}
