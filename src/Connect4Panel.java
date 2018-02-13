import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Connect4Panel extends JPanel {

	public void display(Tile[][] tilePlane) {
		this.setLayout(new GridLayout(1, Connect4.COLUMS));
		this.removeAll();
		JPanel[] colums = new JPanel[Connect4.COLUMS];
		for (int i = 0; i < colums.length; i++) {

			colums[i] = new JPanel();
			colums[i].setLayout(new GridLayout(Connect4.ROWS, 1));

			JPanel[] tiles = new JPanel[Connect4.ROWS];
			for (int j = 0; j < tiles.length; j++) {
				tiles[j] = new JPanel();
				tiles[j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
				if (tilePlane[i][j].set) {
					if (tilePlane[i][j].color) {
						tiles[j].setBackground(Color.YELLOW);
					} else {
						tiles[j].setBackground(Color.RED);
					}
				} else {
					tiles[j].setBackground(Color.BLACK);
				}
				colums[i].add(tiles[j]);
			}
			this.add(colums[i]);
		}

	}

}
