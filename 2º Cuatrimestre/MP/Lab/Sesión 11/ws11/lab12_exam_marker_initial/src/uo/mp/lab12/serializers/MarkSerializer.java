/**
 * 
 */
package uo.mp.lab12.serializers;

import java.util.LinkedList;
import java.util.List;

import uo.mp.lab12.marks.StudentMark;

/**
 * @author blanc
 *
 */
public class MarkSerializer {

	public List<String> serialize(List<StudentMark> marks){
		List<String> res = new LinkedList<>();
		for(StudentMark mark:marks) {
			res.add(serialize(mark));
		}
		return res;
	}

	private String serialize(StudentMark mark) {
		return "Nota de: " + mark.getStudent() + " = " + mark.getValue();
	}
}
