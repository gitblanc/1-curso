package uo.mp.s4.main;

import uo.mp.s4.social_media.model.Message;
import uo.mp.s4.social_media.model.Photo;
import uo.mp.s4.social_media.ui.SocialMedia;

/**
 * @author blanc
 *
 */
public class Main {
	
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		SocialMedia sm = new SocialMedia();
		Message msg = new Message("Msg user", "Mensaje1");
		Photo pic = new Photo("Pic user", "titulo1","foto 1");
		sm.addPost(pic);
		sm.addPost(msg);
		
		sm.print(System.out);
		System.out.println();
		
		System.out.println(sm.toHtmlFormat());
		
	}
}
