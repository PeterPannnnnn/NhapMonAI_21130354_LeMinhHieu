package student;

public class HillClimbingSearchAIgo {
	public Node execute(Node initialState) {
		
		Node current = initialState;
		Node neighbor = null;
		
		while(true) {
			neighbor = current.getBestCandidate();
			if(current.getH() > neighbor.getH()) {
				current = neighbor;
			}else {
				return current;
			}
		}
		
	}
}
