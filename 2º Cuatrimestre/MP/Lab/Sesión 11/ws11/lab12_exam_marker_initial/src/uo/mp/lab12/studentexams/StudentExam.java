/**
 * 
 */
package uo.mp.lab12.studentexams;

import java.util.ArrayList;
import java.util.List;

import uo.mp.lab12.questions.Question;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * @author blanc
 *
 */
public class StudentExam {
	String code; // dentificacion estudiante
	List<String> answers = new ArrayList<>(); // respuestas del examen

	public StudentExam(String studentCode) {
		ArgumentChecks.isTrue(studentCode != null);
		ArgumentChecks.isTrue(!studentCode.isBlank());
		this.code = studentCode;
	}

	public String getStudent() {
		return this.code;
	}

	public String getAnswerToQuestion(int number) {

		return answers.get(number);

	}

	public void addAnswer(String answer) {
		ArgumentChecks.isTrue(answer != null);
		ArgumentChecks.isTrue(!answer.isBlank());
		answers.add(answer);
	}

	public double mark(List<Question> questions) {
		ArgumentChecks.isTrue(questions != null);
		ArgumentChecks.isTrue(!questions.isEmpty());
		int count = 0;
		double puntuation = 0;
		for (Question q : questions) {
			puntuation += q.getMarkForAnswers(answers.get(count));
			count++;
		}
		return puntuation;
	}
	
	private String answersToString(List<String> answers) {
		String cad = "";
		for(String ans : answers) {
			cad += ans + "\t";
		}
		return cad;
	}

	@Override
	public String toString() {
		return this.code + "\t" + answersToString(answers);
	}
}
