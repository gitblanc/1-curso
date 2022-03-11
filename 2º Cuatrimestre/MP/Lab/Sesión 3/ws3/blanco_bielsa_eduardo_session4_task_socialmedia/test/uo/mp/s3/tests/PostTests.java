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
	 * 1 User nulo -> excepción
	 * 2 User vacío -> excepción
	 * 3 FileName nulo -> excepción
	 * 4 FileName vacío -> excepción
	 * 5 Mensaje es nulo -> excepción
	 * 6 Mensaje vacío -> excepción
	 * 7 Todos los parámetros correctos -> se crea el post
	 * 
	 */
	
	/**
	 * GIVEN
	 * WHEN User nulo
	 * THEN excepción
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testPost1() {
		Post p = new Photo(null, "patata", "pepe");
		assertNull(p.getUser());
	}
	
	/**
	 * GIVEN
	 * WHEN User vacío
	 * THEN excepción
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
	 * THEN excepción
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testPost3() {
		Photo p1 = new Photo("user","title",null);
		assertNull(p1.getFileName());
	}
	
	/**
	 * GIVEN
	 * WHEN FileName vacío
	 * THEN excepción
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
	 * THEN excepción
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testPost5() {
		Message p1 = new Message("user2",null);
		assertNull(p1.getMessage());
	}
	/**
	 * GIVEN
	 * WHEN Mensaje vacío 
	 * THEN excepción
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testPost6() {
		Message p1 = new Message("user2","");
		assertNull(p1.getMessage());
	}
	/**
	 * GIVEN
	 * WHEN Todos los parámetros correctos
	 * THEN se crean con éxito
	 */
	@Test
	public void testPost7() {
		Message p1 = new Message("user2","patata");
		Photo ph = new Photo("user","title","foto1");
		assertNotNull(p1);
		assertNotNull(ph);
	}
	
	
	
}