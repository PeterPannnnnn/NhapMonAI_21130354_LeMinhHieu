import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class GreedyBestFirstAIgo implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) { 
		Node goal = model.getGoalState();
		Node initial = model.getInitialState();
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		HashSet<Node> visited = new HashSet<Node>();
		frontier.add(initial);
		
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			visited.add(current);
			if(current.equals(goal)) {
				return current;
			}
			List<Node> successors = model.getSuccessors(current);
			for (Node node : successors) {
				if(!visited.contains(node)) {
					frontier.add(node);
				}
			}
		}
		return null;
	}

}
