/**
 * 
 */
package uo.mp.lab12.marks;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * @author blanc
 *
 */
public class StudentMark implements Comparable<StudentMark>{
	private String student;//identificacion estudiante
	private double value;//nota final
	
	public StudentMark(String st, double value) {
		ArgumentChecks.isTrue(st != null);
		ArgumentChecks.isTrue(!st.isBlank());
		this.setStudent(st);
		this.setValue(value);
	}

	/**
	 * @return the student
	 */
	public String getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(String student) {
		this.student = student;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public int compareTo(StudentMark o) {
		return this.getStudent().compareTo(o.getStudent());
		
	}
}
