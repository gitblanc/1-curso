package uo.mp.lab12.studentexam.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.lab12.questions.Choice;
import uo.mp.lab12.questions.Gap;
import uo.mp.lab12.questions.Value;

public class getMarkForAnswerTests {

	/**
	 * Casos:
	 * 1 Choice: answer igual a opción -> devuelve el valor total
	 * 2 Choice: answer != a opción -> devuelve el valor negativo
	 * 3 Value: answer entre [answer - 0.1 , answer + 0.1] -> devuelve el valor total
	 * 4 Value: answer por debajo de answer - 0.1 -> devuelve 0
	 * 5 Value: answer por encima de answer + 0.1 -> devuelve 0
	 * 6 Gap: answer igual que la palabra correcta -> devuelve el valor total
	 * 7 Gap: answer distinta a la palabra correcta -> devuelve 0
	 */
	Choice q1;
	Value v1;
	Gap g1;
	
	@Before
	public void setUp() {
		q1 = new Choice(1, 1, "a");
		v1 = new Value(2,1,1.0);
		g1 = new Gap(3,1,"patata");
	}
	
	/**
	 * GIVEN objetos choice, value y gap
	 * WHEN answer igual a opción
	 * THEN devuelve el valor total
	 */
	@Test
	public void testGetMarkForAnswer1() {
		String answer = "a";
		assertEquals(1.0, q1.getMarkForAnswers(answer), 0.1);
	}
	
	/**
	 * GIVEN objetos choice, value y gap
	 * WHEN answer != a opción
	 * THEN devuelve el valor negativo
	 */
	@Test
	public void testGetMarkForAnswer2() {
		String answer = "c";
		assertEquals(-0.2, q1.getMarkForAnswers(answer), 0.1);
	}
	
	/**
	 * GIVEN objetos choice, value y gap
	 * WHEN answer entre [answer - 0.1 , answer + 0.1]
	 * THEN devuelve el valor total
	 */
	@Test
	public void testGetMarkForAnswer3() {
		String answer = "0.9";
		assertEquals(1.0, v1.getMarkForAnswers(answer), 0.1);
	}
	
	/**
	 * GIVEN objetos choice, value y gap
	 * WHEN answer por debajo de answer - 0.1
	 * THEN devuelve 0
	 */
	@Test
	public void testGetMarkForAnswer4() {
		String answer = "0.05";
		assertEquals(0, v1.getMarkForAnswers(answer), 0.1);
	}
	
	/**
	 * GIVEN objetos choice, value y gap
	 * WHEN answer por encima de answer + 0.1
	 * THEN devuelve 0
	 */
	@Test
	public void testGetMarkForAnswer5() {
		String answer = "8.05";
		assertEquals(0, v1.getMarkForAnswers(answer), 0.1);
	}
	
	/**
	 * GIVEN objetos choice, value y gap
	 * WHEN answer igual que la palabra correcta
	 * THEN devuelve el valor total
	 */
	@Test
	public void testGetMarkForAnswer6() {
		String answer = "patata";
		assertEquals(1, g1.getMarkForAnswers(answer), 0.1);
	}
	
	/**
	 * GIVEN objetos choice, value y gap
	 * WHEN answer distinta que la palabra correcta
	 * THEN devuelve 0
	 */
	@Test
	public void testGetMarkForAnswer7() {
		String answer = "aceituna";
		assertEquals(0, g1.getMarkForAnswers(answer), 0.1);
	}

}
