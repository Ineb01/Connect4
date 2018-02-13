
public class Connect4 {

	private Tile[][] tilePlane;
	private boolean player = false;

	public static final int COLUMS = 6;
	public static final int ROWS = 5;

	public Connect4() {
		tilePlane = new Tile[COLUMS][];
		for (int i = 0; i < tilePlane.length; i++) {
			tilePlane[i] = new Tile[ROWS];
			for (int j = 0; j < tilePlane[i].length; j++) {

				tilePlane[i][j] = new Tile();

			}

		}
	}

	public Tile[][] getTiles() {
		return tilePlane;
	}

	public Tile getTile(int col, int row) {
		return tilePlane[col][row];
	}

	public boolean addTile(int col) {
		boolean tileSet = false;
		for (int i = tilePlane[col].length - 1; i >= 0 && !tileSet; i--) {
			if (tilePlane[col][i].set == false) {

				tilePlane[col][i].set = true;
				tilePlane[col][i].color = player;

				tileSet = true;
				player = !player;
			}
		}

		// TODO return if there is space left
		return true;
	}

}
