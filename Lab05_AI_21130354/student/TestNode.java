
import java.util.Arrays;
import java.util.List;

public class TestNode {

	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("txt/PuzzleMap.txt", "txt/PuzzleGoalState.txt");

		Node initialState = p.getInitialState();
		System.out.println("Test H1 "+ p.computeH1(initialState));
		System.out.println("Test H2: "+p.computeH2(initialState));
		Node tmp = new Node(initialState);
		System.out.println(initialState.equals(tmp));
//		Node goalState = p.getGoalState();
//		System.out.println(p.getInitialState());
		System.out.println("H: "+initialState.getH());
//		System.out.println(Arrays.toString(initialState.getWhiteTilePosition()));
//		System.out.println(p.getGoalState());
		Node re = p.moveWhiteTile(initialState, 'd');
//
		System.out.println(re);
		System.out.println(re.getH());
		System.out.println(initialState);
//		System.out.println(Arrays.toString(re.getWhiteTilePosition()));
//		System.out.println(p.computeH(init, goal));

//		 System.out.println(p.getInitialState());
//		 System.out.println(p.getGoalState());
//		
//		 List<Node> children = p.getSuccessors(initialState);
//		 System.out.println("Size: "+children.size());
//		 for (Node child : children) {
//		 System.out.println(child.getH()+" "+p.computeH1(child) );
//		 }
//		System.out.println("Test Astart");
//		IPuzzleAlgo algorithm = new GreedyBestFirstAIgo();
//		Node solution = algorithm.execute(p);
		
		
	}
}
