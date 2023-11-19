import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class GA_NQueenAIgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}
	
	public Node execute() {
		this.initPopulation();
		List<Node> newPopulation = new ArrayList<Node>();
		double probability = rd.nextDouble();
		int k = 0;
		while (k++ < MAX_ITERATIONS) {
			for (int i = 0; i < POP_SIZE; i++) {
				Node x = getParentByRandomSelection();
				Node y = getParentByRandomSelection();
				Node child = reproduce(x, y);
				if (probability < MUTATION_RATE) {
					mutate(child);
				}
				if (child.getH() == 0) {
					return child;
				}
				newPopulation.add(child);
			}
			population = newPopulation;
		}

		Collections.sort(population);
		Node result = population.get(0);

		return result;
	}

	// Mutate an individual by selecting a random Queen and //move it to a random
	// row.
	public void mutate(Node node) {
		int rdRow = rd.nextInt(Node.N);
		int rdQueen = node.getRow(rd.nextInt(Node.N));
		node.setRow(rdQueen, rdRow);
	}

	public Node reproduce(Node x, Node y) {

		int c = rd.nextInt(Node.N);

		Node result = new Node();

		for (int i = 0; i < c; i++) {
			result.setRow(i, x.getRow(i));
		}
		for (int i = c + 1; i < Node.N; i++) {
			result.setRow(i, y.getRow(i));
		}

		return result;
	}

	// Select K individuals from the population at random and //select the best out
	// of these to become a parent.
	public Node getParentByTournamentSelection() {
		this.initPopulation();
		int k = 3;
		List<Node> list = new ArrayList<Node>();
		Node result = null;
		for (int i = 0; i < k; i++) {
			result = population.get(rd.nextInt(POP_SIZE));
			list.add(result);
		}
		result = list.get(0);
		for (Node node : list) {
			if (result.getH() > node.getH()) {
				result = node;
			}
		}
		return result;
	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() {
		Node node = population.get(rd.nextInt(POP_SIZE));
		return node;
	}
	public static void main(String[] args) {
		GA_NQueenAIgo ga = new GA_NQueenAIgo();
		Node result = ga.execute();
		System.out.println("H: "+ result.getH());
		result.displayBoard();
	}
}
