import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class AStartSearchAIgo implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {

		Node goal = model.getGoalState();
		Node initial = model.getInitialState();
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByF);
		HashSet<Node> visited = new HashSet<Node>();
		frontier.add(initial);

		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			visited.add(current);
			if (current.equals(goal)) {
				return current;
			}
			List<Node> successors = model.getSuccessors(current);
			for (Node node : successors) {

				if (!visited.contains(node)) {
					frontier.add(node);
				} else {
					node.setG(current.getG() + 1);
					node.setH(model.computeH1(current));
				}
			}

		}
		return null;
	}
	

}
