package uo.mp.s3.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import uo.mp.s4.social_media.model.Message;
import uo.mp.s4.social_media.model.Photo;
import uo.mp.s4.social_media.model.Post;

public class PostTests {

	/*
	 * Casos
	 * 1 User nulo -> excepci�n
	 * 2 User vac�o -> excepci�n
	 * 3 FileName nulo -> excepci�n
	 * 4 FileName vac�o -> excepci�n
	 * 5 Mensaje es nulo -> excepci�n
	 * 6 Mensaje vac�o -> excepci�n
	 * 7 Todos los par�metros correctos -> se crea el post
	 * 
	 */
	
	/**
	 * GIVEN
	 * WHEN User nulo
	 * THEN excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testPost1() {
		Post p = new Photo(null, "patata", "pepe");
		assertNull(p.getUser());
	}
	
	/**
	 * GIVEN
	 * WHEN User vac�o
	 * THEN excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testPost2() {
		Post p = new Photo("", "patata", "pepe");
		assertNull(p.getUser());
	}
	
	/**
	 * GIVEN
	 * WHEN FileName nulo
	 * THEN excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testPost3() {
		Photo p1 = new Photo("user","title",null);
		assertNull(p1.getFileName());
	}
	
	/**
	 * GIVEN
	 * WHEN FileName vac�o
	 * THEN excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testPost4() {
		Photo p1 = new Photo("user","title","");
		assertNull(p1.getFileName());
	}
	/**
	 * GIVEN
	 * WHEN Mensaje es nulo
	 * THEN excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testPost5() {
		Message p1 = new Message("user2",null);
		assertNull(p1.getMessage());
	}
	/**
	 * GIVEN
	 * WHEN Mensaje vac�o 
	 * THEN excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testPost6() {
		Message p1 = new Message("user2","");
		assertNull(p1.getMessage());
	}
	/**
	 * GIVEN
	 * WHEN Todos los par�metros correctos
	 * THEN se crean con �xito
	 */
	@Test
	public void testPost7() {
		Message p1 = new Message("user2","patata");
		Photo ph = new Photo("user","title","foto1");
		assertNotNull(p1);
		assertNotNull(ph);
	}
	
	
	
}