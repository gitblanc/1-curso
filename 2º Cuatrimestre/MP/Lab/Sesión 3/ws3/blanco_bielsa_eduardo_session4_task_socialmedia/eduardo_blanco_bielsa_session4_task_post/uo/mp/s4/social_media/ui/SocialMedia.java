package uo.mp.s4.social_media.ui;

import java.io.PrintStream;
import java.util.ArrayList;

import uo.mp.checks.ArgumentsCheck;
import uo.mp.s4.social_media.model.Post;

public class SocialMedia {

	private ArrayList<Post> social = new ArrayList<Post>();

	/**
	 * M�todo que a�ade posts a la red social
	 * 
	 * @param post
	 */
	public void addPost(Post post) {
		ArgumentsCheck.isTrue(post != null, "Error: par�metro nulo");
			social.add(post);
	}

	/**
	 * M�todo que imprime los posts
	 * 
	 * @param out
	 */
	public void print(PrintStream out) {
		for (Post post : social) {
			post.print(out);
		}
	}
	
	public ArrayList<Post> findPostsByUser(String user){
		ArgumentsCheck.isTrue(user != null, "Error: user nulo.");
		ArrayList<Post> aux = new ArrayList<Post>();
		for(Post post : social) {
			if(post.getUser().equals(user)) {
				aux.add(post);
			}
		}
		return aux;
	}
	
	/**
	 * M�todo toHtmlFormat() que formatea los post.
	 */
	public String toHtmlFormat(){
		String cad = "";
		for(Post post : social) {
			cad += post.toHtmlFormating() + "\n";
		}
		return cad;
	}
	
}
