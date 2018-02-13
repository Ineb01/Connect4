import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	private Connect4 connect4 = new Connect4();
	private Connect4Panel displayConnect4 = new Connect4Panel();

	public Frame() {

		this.add(new ControllPanel(), BorderLayout.NORTH);

		this.add(displayConnect4, BorderLayout.CENTER);

		update();

		this.setSize(600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void update() {
		displayConnect4.display(connect4.getTiles());
		this.setVisible(true);
	}

	private class ControllPanel extends JPanel {
		private JButton[] insertButtons;

		public ControllPanel() {
			this.setLayout(new GridLayout(1, Connect4.COLUMS));
			insertButtons = new JButton[Connect4.COLUMS];
			int i = 0;
			InsertAction insertAction = new InsertAction();
			for (JButton jButton : insertButtons) {
				jButton = new JButton("Y");
				jButton.setActionCommand("" + i);
				jButton.addActionListener(insertAction);
				this.add(jButton);
				i++;
			}
		}
	}

	private class InsertAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			connect4.addTile(Integer.parseInt(e.getActionCommand()));
			update();

		}

	}

	public static void main(String[] args) {
		new Frame();
	}

}
