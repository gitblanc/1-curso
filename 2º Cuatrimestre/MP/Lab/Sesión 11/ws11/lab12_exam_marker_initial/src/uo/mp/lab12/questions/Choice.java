package uo.mp.lab12.questions;

import uo.mp2021.util.checks.ArgumentChecks;

public class Choice extends Question{
	String option;
	
	public Choice(int num, double w, String option) {
		super(num, w);
		ArgumentChecks.isTrue(option != null);
		setOption(option);
	}
	
	
	@Override
	public double getMarkForAnswers(String answer) {
		if(answer.equals(this.option)) {
			return this.weight;
		}
		else {
			return -0.2*this.weight;
		}
	}

	public String getOption() {
		return this.option;
	}
	
	private void setOption(String option){
		ArgumentChecks.isTrue(option.equals("a") || option.equals("b") 
				|| option.equals("c") || option.equals("d"), "Error: respuesta inválida");
		this.option = option;
	}

	@Override
	public String toString() {
		return this.number + "\tchoice\t" + this.getWeight() + "\t" +  this.getOption();
	}
	
}
