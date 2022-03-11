package uo.mp.s3.socialmedia.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import uo.mp.s4.social_media.model.Message;
import uo.mp.s4.social_media.model.Photo;
import uo.mp.s4.social_media.model.Post;
import uo.mp.s4.social_media.ui.SocialMedia;

public class AddPostTest {
	/*
	 * Casos
	 * 
	 * 1 Post nulo -> excepción
	 * 2 Se añade 1 post
	 * 3 Se añaden varios post
	 */
	
	/**
	 * GIVEN
	 * WHEN Post nulo
	 * THEN excepción
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testAddPost1() {
		SocialMedia sm = new SocialMedia();
		sm.addPost(null);
	}
	
	/**
	 * GIVEN
	 * WHEN Se añade 1 post
	 * THEN
	 */
	@Test
	public void testAddPost2() {
		SocialMedia sm = new SocialMedia();
		Post p = new Photo("user1", "file1", "user");
		sm.addPost(p);
		assertNotNull(sm);
	}

	/**
	 * GIVEN
	 * WHEN Se añaden varios post
	 * THEN
	 */
	@Test
	public void testAddPost3() {
		SocialMedia sm = new SocialMedia();
		Post p = new Photo("user1", "file1", "user");
		Post p2 = new Message("user1", "user");
		sm.addPost(p);
		sm.addPost(p2);
		assertNotNull(sm);
	}
}
