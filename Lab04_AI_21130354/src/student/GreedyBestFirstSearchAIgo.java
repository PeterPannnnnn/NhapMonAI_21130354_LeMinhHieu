package student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

import student.Node;

public class GreedyBestFirstSearchAIgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				int rs = Double.compare(o1.getH(), o2.getH());
				if (rs == 0)
					return o1.getLabel().compareToIgnoreCase(o2.getLabel());
				return rs;
			}
		});
		ArrayList<Node> explored = new ArrayList<Node>();
		HashSet<Node> visited = new HashSet<Node>();
		frontier.add(root);
		visited.add(root);

		ArrayList<String> path = null;
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(goal)) {

				path = (ArrayList<String>) NodeUtils.printPath(currentNode);

				return currentNode;
			}

			List<Node> nodes = currentNode.getChildrenNodes();
			List<Edge> edge = currentNode.getChildren();
			for (Edge ed : edge) {
				Node nod = ed.getEnd();
				if (!visited.contains(nod)) {
					visited.add(nod);
					nod.setParent(currentNode);
					frontier.add(nod);

				}
			}

		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				int rs = Double.compare(o1.getH(), o2.getH());
				if (rs == 0)
					return o1.getLabel().compareToIgnoreCase(o2.getLabel());
				return rs;
			}
		});
		ArrayList<Node> explored = new ArrayList<Node>();
		HashSet<Node> visited = new HashSet<Node>();
		
		Node startNode = findNode(root, start);
		startNode.setParent(null);
		
		frontier.add(startNode);
		visited.add(startNode);

		ArrayList<String> path = null;
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(goal)) {

				path = (ArrayList<String>) NodeUtils.printPath(currentNode);

				return currentNode;
			}

			List<Node> nodes = currentNode.getChildrenNodes();
			List<Edge> edge = currentNode.getChildren();
			for (Edge ed : edge) {
				Node nod = ed.getEnd();
				if (!visited.contains(nod)) {
					visited.add(nod);
					nod.setParent(currentNode);
					frontier.add(nod);

				}
			}

		}
		return null;
	}
	
	private Node findNode(Node node, String label) {
		if (node.getLabel().equals(label)) {
			return node;
		}
		for (Node nodeChild : node.getChildrenNodes()) {
			Node foundNode = findNode(nodeChild, label);
			if (foundNode != null) {
				return foundNode;
			}
		}

		return null;
	}
	
	
	
	

}
