package game_nim_student;

import java.util.List;

public class MinimaxAlgo {

	public void execute(Node node) {
		int v = minValue(node);
		System.out.println("V: " + v);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		if (node.isTerminal()) {
			return 0;
		}
		int value = Integer.MIN_VALUE;

		List<Node> child = node.getSuccessors();

		for (Node n : child) {
			value = Math.max(value, minValue(n));

		}

		return value;
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) {
		if (node.isTerminal()) {
			return 1;
		}
		int value = Integer.MAX_VALUE;

		for (Node n : node.getSuccessors()) {
			value = Math.min(value, maxValue(n));

			if (value == maxValue(n)) {
				System.out.println("Best Node For Min: " + n);
			}

		}
		return value;
	}

}
