package student;

public class TestAStar {
	public static void main(String[] args) {
		Node s = new Node("S", 6);
		Node b = new Node("B", 4);
		Node a = new Node("A", 3);
		Node c = new Node("C", 4);
		Node d = new Node("D", 3.5);
		Node e = new Node("E", 1);
		Node f = new Node("F", 1);
		Node g = new Node("G", 0);
		
		s.addEdge(b, 3);
		s.addEdge(a, 2);
		a.addEdge(c, 3);
		b.addEdge(d, 3);
		b.addEdge(c, 1);
		c.addEdge(e, 3);
		c.addEdge(d, 1);
		d.addEdge(f, 2);
		f.addEdge(g, 1);
		e.addEdge(g, 2);
		
		System.out.println("Test Greedy Best-First Search: ");
		IInformedSearchAlgo gbfSearch = new GreedyBestFirstSearchAIgo();
		Node n = gbfSearch.execute(s, g.getLabel());
		System.out.println(NodeUtils.printPath(n));
		
		System.out.println("Test Greedy Best-First Search with node Start: ");
		Node n2 = gbfSearch.execute(s, b.getLabel() ,g.getLabel());
		System.out.println(NodeUtils.printPath(n2));
		
		
		
		System.out.println("Test A* Search: ");
		AStartSearchAIgo aStar = new AStartSearchAIgo();
		Node res = aStar.execute(s, g.getLabel());
		System.out.println(NodeUtils.printPath(res));
		System.out.println("Test A* Search with node Start: ");
		Node res2 = aStar.execute(s, c.getLabel() , g.getLabel());
		System.out.println(NodeUtils.printPath(res2));
		
		
		System.out.println("Test Admissible H: ");
		System.out.println(aStar.isAdmissibleH(s, g.getLabel()));
		
		
	}
}
