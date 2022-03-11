package uo.mp.battleship.gui;

import static java.lang.Math.max;
import static uo.mp.battleship.gui.swing.builders.BorderedPanelBuilder.borderedPanel;
import static uo.mp.battleship.gui.swing.builders.ButtonBuilder.button;
import static uo.mp.battleship.gui.swing.builders.FrameBuilder.frame;
import static uo.mp.battleship.gui.swing.builders.GridPanelBuilder.gridPanel;
import static uo.mp.battleship.gui.swing.builders.LabelBuilder.label;

import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Represents the structure of the ocean field window. Its unique public method
 * is the constructor whose mission is to assemble the visual components of the 
 * screen.
 * 
 * This class is abstract and must be complimented, through inheritance, with
 * the methods needed from the view model.
 * 
 * @author alb
 */
/*package*/ abstract class BoardScreen {
	private static final int CELL_HEIGHT = 45;
	private static final int CELL_WIDTH = 45;

	protected int size;
	
	protected JFrame window;
	protected JButton[][] buttons;
	protected JLabel flagsLabel;
	protected JLabel timeLabel;
	protected JLabel msgLabel;
	private int x;
	private int y;
	private String title;

	public BoardScreen(int size, int x, int y, String title) {
	
		this.x = x;
		this.y = y;
		this.title = title;

		this.size = size;
		
		this.buttons = createSquareButtons();
		this.flagsLabel = createFlagsLabel();
		this.msgLabel = createMessageLabel();
		this.timeLabel = createTimeLabel();
		this.window = createWindow();
	}
	

	private JFrame createWindow() {
		int width = max(350, size * CELL_WIDTH + 20);
		int height = size * CELL_HEIGHT + 100;
		
		return frame()
				.title(title)
				.position(x, y)
				.size( width, height )
				.content( 
					borderedPanel()
						.atNorth(
							gridPanel(1, 3)
								.add(msgLabel)
								//.add(flagsLabel)
								//.add(msgLabel)
								//.add(timeLabel)
						)
						.atCenter(
							gridPanel(size, size)
								.add( buttons )
						)
				)
				.build();
	}
	
	private JLabel createTimeLabel() {
		return label().text("0000").alignRight().fontSize( 30.0f ).build();
	}

	private JLabel createFlagsLabel() {
		return label().text("000").alignLeft().fontSize( 30.0f ).build();
	}

	private JLabel createMessageLabel() {
		return label().text("").alignCenter().fontSize( 20.0f ).build();
	}

	private JButton[][] createSquareButtons() {
		JButton[][] res = new JButton[size][size];
		MouseListener onClick = createMouseListener();
		
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				res[y][x] = createSquareButton(y, x, onClick); 
			}
		}
		return res;
	}

	protected abstract MouseListener createMouseListener();

	private JButton createSquareButton(int y, int x, MouseListener onClick) {
		return button()
				.margin(0, 0, 0, 0)
				.command( y + "-" + x )
				.listener( onClick )
				.build();
	}

}
