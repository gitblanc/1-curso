/**
 * 
 */
package uo.mp.lab12.marks;

import java.util.Comparator;

/**
 * @author blanc
 *
 */
public class StudentMarkByValue implements Comparator<StudentMark>{

	@Override
	public int compare(StudentMark o1, StudentMark o2) {
		int diff = (int) (o1.getValue() - o2.getValue());
		if(diff == 0) {
			return o2.getStudent().compareTo(o1.getStudent());
		}
		return diff;
		
	}
	
}
