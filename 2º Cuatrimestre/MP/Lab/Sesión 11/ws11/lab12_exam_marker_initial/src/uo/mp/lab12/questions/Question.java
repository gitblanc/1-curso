/**
 * 
 */
package uo.mp.lab12.questions;

/**
 * @author blanc
 *
 */
public abstract class Question {
	protected int number;
	protected double weight;

	public Question(int num, double w) {
		this.number = num;
		this.weight = w;
	}

	public double getWeight() {
		return this.weight;
	}

	public abstract double getMarkForAnswers(String answer);

	@Override
	public abstract String toString();
}
