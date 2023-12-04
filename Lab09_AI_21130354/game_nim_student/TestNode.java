package game_nim_student;

import java.util.Arrays;
import java.util.List;

public class TestNode {
	public static void main(String[] args) {
		Node node = new Node();
		Integer[] data = { 7 };
		node.addAll(Arrays.asList(data));

		MinimaxAlgo algo = new MinimaxAlgo();
		algo.execute(node);
		
		Node n2 = new Node();
		n2.add(3);
		n2.add(3);
		n2.add(1);

		
		List<Node> list = n2.getSuccessors();
		System.out.println(list.size());
		System.out.println(7/2);
		for (Node node2 : list) {
			System.out.println(node2.toString());
		}
	}
}