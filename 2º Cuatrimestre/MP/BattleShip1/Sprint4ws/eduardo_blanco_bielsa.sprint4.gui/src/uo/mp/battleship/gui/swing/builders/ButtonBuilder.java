package uo.mp.battleship.gui.swing.builders;

import java.awt.Insets;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class ButtonBuilder implements ComponentBuilder {

	private String text = "";
	private Insets margin = new Insets(5, 5, 5, 5);
	private String command = "";
	private MouseListener mouseListener = null;

	public static ButtonBuilder button() {
		return new ButtonBuilder();
	}

	public ButtonBuilder margin(int top, int left, int bottom, int right) {
		this.margin = new Insets(top, left, bottom, right);
		return this;
	}

	public ButtonBuilder command(String string) {
		this.command = string;
		return this;
	}

	public  ButtonBuilder listener(MouseListener listener) {
		this.mouseListener = listener;
		return this;
	}

	@Override
	public JButton build() {
		JButton res = new JButton();
		res.setText(text);
		res.setMargin( margin );
		res.setActionCommand( command );
		res.addMouseListener( mouseListener );
		return res;
	}

}
