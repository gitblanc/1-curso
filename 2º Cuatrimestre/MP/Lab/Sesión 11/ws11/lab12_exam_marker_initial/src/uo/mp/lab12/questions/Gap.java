/**
 * 
 */
package uo.mp.lab12.questions;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * @author blanc
 *
 */
public class Gap extends Question{

	private String word;
	
	public Gap(int num, double w, String word) {
		super(num, w);
		this.word = word;
	}

	@Override
	public double getMarkForAnswers(String answer) {
		ArgumentChecks.isTrue(answer != null);
		
		if(answer.equals(word)) {
			return this.weight;
		}else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return this.number + "\tgap\t" + this.getWeight() + "\t" + this.word;
	}

}
