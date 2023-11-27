package game_alphabeta_student;

import java.util.Comparator;
import java.util.List;

public class AlphaBetaRightToLeftSearchAlgo implements ISearchAlgo {

    @Override
    public void execute(Node node) {
        int alpha = Integer.MIN_VALUE;
        int beta = Integer.MAX_VALUE;
        Node bestChild = null;
        int bestValue = Integer.MIN_VALUE;

        List<Node> successors = node.getChildren();
        for (int i = successors.size() - 1; i >= 0; i--) {
            Node child = successors.get(i);
            int value = minValue(child, alpha, beta);
            if (value > bestValue) {
                bestValue = value;
                bestChild = child;
                System.out.println("Best Move: " + bestChild);
            }
            alpha = Math.max(alpha, bestValue);
        }
        System.out.println("Alpha: " + alpha);
    }

    public int maxValue(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int v = Integer.MIN_VALUE;
        List<Node> successors = node.getChildren();
        for (int i = successors.size() - 1; i >= 0; i--) {
            Node child = successors.get(i);
            int childValue = minValue(child, alpha, beta);
            v = Math.max(v, childValue);
            if (v >= beta) {
                return v;
            }
            alpha = Math.max(alpha, v);
        }
        return v;
    }

    public int minValue(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int v = Integer.MAX_VALUE;
        List<Node> successors = node.getChildren();
        for (int i = successors.size() - 1; i >= 0; i--) {
            Node child = successors.get(i);
            int childValue = maxValue(child, alpha, beta);
            v = Math.min(v, childValue);
            if (v <= alpha) {
                return v;
            }
            beta = Math.min(beta, v);
        }
        return v;
    }
}