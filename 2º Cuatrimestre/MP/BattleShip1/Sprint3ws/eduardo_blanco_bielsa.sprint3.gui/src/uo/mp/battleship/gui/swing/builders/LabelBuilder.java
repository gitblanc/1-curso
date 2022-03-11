package uo.mp.battleship.gui.swing.builders;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelBuilder implements ComponentBuilder {

	private String text = "";
	private int aligmentType = SwingConstants.LEFT;
	private float fontSize = 10.0f;

	public static LabelBuilder label() {
		return new LabelBuilder();
	}

	public LabelBuilder text(String text) {
		this.text = text;
		return this;
	}

	public LabelBuilder alignLeft() {
		aligmentType = SwingConstants.LEFT;
		return this;
	}

	public LabelBuilder alignRight() {
		aligmentType = SwingConstants.RIGHT;
		return this;
	}

	public LabelBuilder alignCenter() {
		aligmentType = SwingConstants.CENTER;
		return this;
	}

	public LabelBuilder fontSize(float size) {
		fontSize = size;
		return this;
	}

	@Override
	public JLabel build() {
		JLabel lbl = new JLabel();
		lbl.setText(text);
		lbl.setHorizontalAlignment( aligmentType );
		lbl.setFont( lbl.getFont().deriveFont( fontSize ) );
		return lbl;
	}

}
