package game_nim_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		List<Node> result = new ArrayList<Node>();
		data.sort(DESCOMPARATOR);

		for (int i = 0; i < data.size(); i++) {
			int current = data.get(i);

			int stop = 0;
			if (current % 2 == 0) {
				stop = current / 2;
			} else {
				stop = (current / 2) + 1;
			}
			for (int j = 1; j < stop; j++) {
				if (j != current - j) {
					Node n = new Node();
					n.add(j);
					n.add(current - j);
					for (int k = 0; k < data.size(); k++) {
						if (k != i) {
							n.add(data.get(k));
						}
					}
					n.getData().sort(DESCOMPARATOR);
					if (!result.contains(n)) {
						result.add(n);
					}
				}
			}
		}

		return result;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		data.sort(DESCOMPARATOR);
		if (data.get(0) <= 2)
			return true;

		return false;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
