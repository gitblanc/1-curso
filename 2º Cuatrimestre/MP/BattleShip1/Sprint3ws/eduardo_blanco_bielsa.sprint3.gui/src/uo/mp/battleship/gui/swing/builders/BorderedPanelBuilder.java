package uo.mp.battleship.gui.swing.builders;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BorderedPanelBuilder implements ContainerBuilder, ComponentBuilder {
	private Map<String, ComponentBuilder> builders = new HashMap<>();

	public static BorderedPanelBuilder borderedPanel() {
		return new BorderedPanelBuilder();
	}

	public BorderedPanelBuilder atNorth(ComponentBuilder builder) {
		builders.put(BorderLayout.NORTH, builder);
		return this;
	}
	
	public BorderedPanelBuilder atCenter(ComponentBuilder builder) {
		builders.put(BorderLayout.CENTER, builder);
		return this;
	}
	
	public BorderedPanelBuilder atSouth(ComponentBuilder builder) {
		builders.put(BorderLayout.SOUTH, builder);
		return this;
	}

	public BorderedPanelBuilder atEast(ComponentBuilder builder) {
		builders.put(BorderLayout.EAST, builder);
		return this;
	}

	public BorderedPanelBuilder atWest(ComponentBuilder builder) {
		builders.put(BorderLayout.WEST, builder);
		return this;
	}

	@Override
	public JPanel build() {
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));

		for (String orientation: builders.keySet()) {
			ComponentBuilder builder = builders.get(orientation);
			panel.add( builder.build(), orientation );
		}

		return panel;
	}

}
