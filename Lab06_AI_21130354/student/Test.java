package student;

import sa_tsp.SimulatedAnnealing;

public class Test {
	public static void main(String[] args) {
		Node state = new Node();
		state.generateBoard();
		state.displayBoard();
		
		System.out.println(" test random selectNextRandomCandidate(): ");
		Node random = state.selectNextRandomCandidate();
		random.displayBoard();
		
		System.out.println("Optimized distance for travel: " + SimulatedAnnealingNQueen.simulateAnnealing(10, 10000, 0.9995));
		HillClimbingRandomSearchAIgo hcr = new HillClimbingRandomSearchAIgo();
		Node hc_random = hcr.executeHillClimbingWithRandomRestart(state);
		hc_random.displayBoard();
	}
}
