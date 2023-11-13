package student;

public class HillClimbingRandomSearchAIgo {
	int stepClimbed = 0;
	int stepClimbedAfterRandomRestart = 0;
	int randomRestarts = 0;
	public Node executeHillClimbingWithRandomRestart(Node initialState) {
			
		
		HillClimbingSearchAIgo hcsa = new HillClimbingSearchAIgo();
		
		Node current = initialState;
		Node neighbor = null;
		
		Node state = hcsa.execute(current);
		while (state.getH() != 0) {
			System.out.println(stepClimbed++);
			System.out.println(stepClimbedAfterRandomRestart++);
			System.out.println(randomRestarts++);
			state.generateBoard();
			state = hcsa.execute(state);
		}
		return state;
	}

}
