package student;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
		this.setRow(this.getRow() + 1);
		if (this.getRow() == Node.N) {
			this.setRow(0);
		}
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		int diago = Math.abs(this.getRow() - q.getRow()) - Math.abs(this.getColumn() - q.getColumn());
		if (this.getRow() == q.getRow() || this.column == q.column || diago == 0) {
			return true;
		}
		return false;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public boolean check(Queen q) {
		if(this.getColumn() == q.getColumn() && this.getRow() == q.getRow()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}

	public static void main(String[] args) {
		System.out.println(1);
	}
}
