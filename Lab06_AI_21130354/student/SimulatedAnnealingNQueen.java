package student;

import java.util.Random;

public class SimulatedAnnealingNQueen {
	public static double simulateAnnealing(double startingTemperature, int numberOfIterations, double coolingRate) {
		Node state = new Node();
		double t = startingTemperature;
		state.generateBoard();
		double bestDistance = state.getH();
		Node bestSolution = state;
		Node currentSolution = bestSolution;
		for (int i = 0; i < numberOfIterations; i++) {
			if(t==0) {
				return currentSolution.getH();
			} else {
				
				currentSolution.selectNextRandomCandidate();
				double currentDistance = currentSolution.getH();
				if(currentDistance < bestDistance) {
					bestDistance = currentDistance;
				}  else if (Math.exp((bestDistance - currentDistance) / t) < Math.random()) {
					
					currentSolution = bestSolution;
				
				}
				t *= coolingRate;
				
			}
		}
		
		return  bestDistance;
	}
}
