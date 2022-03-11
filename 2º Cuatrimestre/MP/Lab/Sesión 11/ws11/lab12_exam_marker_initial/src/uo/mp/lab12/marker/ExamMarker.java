package uo.mp.lab12.marker;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uo.mp.lab12.marks.StudentMark;
import uo.mp.lab12.marks.StudentMarkByValue;
import uo.mp.lab12.parsers.QuestionParser;
import uo.mp.lab12.parsers.StudentParser;
import uo.mp.lab12.questions.Question;
import uo.mp.lab12.serializers.MarkSerializer;
import uo.mp.lab12.studentexams.StudentExam;
import uo.mp.util.file.FileUtil;
import uo.mp.util.file.ZipFileUtil;

public class ExamMarker {
	private List<Question> questions = new ArrayList<>();
	private List<StudentExam> studentExams = new ArrayList<>();
	private List<StudentMark> marks = new ArrayList<>();

	public void loadQuestions(String examModelFileName) throws FileNotFoundException {
		List<String> lines = new FileUtil().readLines(examModelFileName);
		List<Question> questions = new QuestionParser().parse(lines);
		addQuestions(questions);
	}

	private void addQuestions(List<Question> questions) {
		for (Question q : questions) {
			this.questions.add(q);
		}
	}

	public void loadStudentExams(String answersFileName) throws FileNotFoundException {
		List<String> lines = new ZipFileUtil().readLines(answersFileName);
		List<StudentExam> exams = new StudentParser().parse(lines);
		addExams(exams);
	}

	private void addExams(List<StudentExam> exams) {
		for (StudentExam exam : exams) {
			this.studentExams.add(exam);
		}
	}

	public List<StudentMark> getMarksByStudent() {
		mark();
		Collections.sort(marks);
		return this.marks;
	}

	public List<StudentMark> getMarksByMark() {
		List<StudentMark> studentMarks = this.marks;
		Collections.sort(studentMarks, new StudentMarkByValue());
		Collections.reverse(studentMarks);
		return studentMarks;
	}

	public void mark() {
		List<StudentMark> stList = new ArrayList<>();
		for (StudentExam st : studentExams) {
			String code = st.getStudent();
			double puntuation = st.mark(questions);
			stList.add(new StudentMark(code, puntuation));
		}
		this.marks = stList;
	}

	public void saveResults(String resultsFileName) throws FileNotFoundException {
		List<StudentMark> marks = getMarks();
		List<String> lines = new MarkSerializer().serialize(marks);
		new FileUtil().writeLines(resultsFileName, lines);
	}

	private List<StudentMark> getMarks() {
		return new ArrayList<>(marks);
	}

	public List<StudentExam> getExams() {

		return new ArrayList<>(studentExams);
	}

	public List<Question> getQuestions() {
		return new ArrayList<>(questions);
	}

}
