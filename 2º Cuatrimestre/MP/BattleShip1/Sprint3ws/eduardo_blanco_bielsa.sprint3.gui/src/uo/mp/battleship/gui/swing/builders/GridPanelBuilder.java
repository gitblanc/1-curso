package uo.mp.battleship.gui.swing.builders;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GridPanelBuilder implements ContainerBuilder, ComponentBuilder {
	private int rows;
	private int cols;
	private List<ComponentBuilder> builders = new ArrayList<>();
	private List<Component> components = new ArrayList<>();

	public static GridPanelBuilder gridPanel(int rows, int cols) {
		return new GridPanelBuilder(rows, cols);
	}

	public GridPanelBuilder(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
	}

	public GridPanelBuilder add(Component component) {
		this.components.add( component );
		return this;
	}

	public GridPanelBuilder add(ComponentBuilder builder) {
		this.builders.add( builder );
		return this;
	}

	public GridPanelBuilder add(Component[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				components.add( matrix[i][j] );
			}
		}
		return this;
	}

	@Override
	public JPanel build() {
		JPanel panel = new JPanel();
		panel.setLayout( new GridLayout(rows, cols) );
		
		for(ComponentBuilder builder: builders) {
			components.add( builder.build() );
		}
		
		for(Component component: components) {
			panel.add(component);
		}
		
		return panel;
	}

}
