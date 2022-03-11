package uo.mp.lab12;

import java.io.FileNotFoundException;
import java.util.List;

import uo.mp.lab12.marker.ExamMarker;
import uo.mp.lab12.marks.StudentMark;
import uo.mp.lab12.questions.Question;
import uo.mp.lab12.studentexams.StudentExam;
import uo.mp.newsstand.ui.console.Console;

public class Main {

	private static final String EXAM_MODEL_FILE = "questions.txt";
	private static final String ANSWERS_FILE = "exams.txt.gz";
	private static final String RESULTS_FILE = "marks.txt";

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		try {
			simulateScenario();
		} catch (RuntimeException e) {
			handleSystemError(e);
		}catch (Exception e) {
			handleUserError(e);
		}
	}

	private void handleSystemError(RuntimeException e) {
		String str = "Error del sistema. \n" + "Por favor, póngase en contacto" + " con el servicio técnico";
		Console.println(str);
	}

	private void handleUserError(Exception e) {
		String str = "Ha habido un error \n" + e.getMessage() + ".Por favor, inténtelo de nuevo";
		Console.println(str);
		
	}

	/**
	 * There is no user interface for this small program. This method
	 * simulates an example scenario of use.
	 * @throws FileNotFoundException 
	 */
	private void simulateScenario() throws FileNotFoundException {
		ExamMarker ex = new ExamMarker();
		ex.loadQuestions( EXAM_MODEL_FILE );
		showQuestions(ex.getQuestions());
		ex.loadStudentExams( ANSWERS_FILE );
		showExams(ex.getExams());

		ex.mark();

		showMarks( ex.getMarksByMark() );
		showMarks( ex.getMarksByStudent() );
		ex.saveResults( RESULTS_FILE );
	}

	private void showQuestions(List<Question> questions) {
		System.out.println("---------------------------------------------");
		System.out.println("List of questions");
		for(Question q: questions) {
			System.out.println( q.toString() );
		}
	}

	private void showExams(List<StudentExam> exams) {
		System.out.println("---------------------------------------------");
		System.out.println("List of exams");
		for(StudentExam se: exams) {
			System.out.println( se.toString() );
		}
	}

	private void showMarks(List<StudentMark> marks) {
		System.out.println("---------------------------------------------");
		System.out.println("List of marks");
		for(StudentMark mark: marks) {
			System.out.println( mark.getStudent() + " " + mark.getValue() );
		}
	}

}
