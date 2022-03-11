/**
 * 
 */
package uo.mp.lab12.questions;

/**
 * @author blanc
 *
 */
public class Value extends Question{

	private double value;
	
	public Value(int num, double w, double val) {
		super(num, w);
		this.value = val;
	}
	
	@Override
	public double getMarkForAnswers(String answer) {
		double answerValue = Double.parseDouble(answer);
		return checkPuntuation(answerValue);
		
	}

	/**
	 * @param answerValue
	 * @return double
	 */
	private double checkPuntuation(double answerValue) {
		double ans1 = this.value - 0.1;
		double ans2 = this.value + 0.1;
		if(answerValue <= ans2 && answerValue >= ans1) {
			return this.weight;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return this.number + "\tvalue\t" + this.getWeight() + "\t" + this.value;
	}

	
}
