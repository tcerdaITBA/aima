package search.algorithm;

import search.*;
import search.framework.Node;
import search.framework.Problem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Optional;

public class BreadthFirstSearch<S,A> extends GraphSearch<S,A> {
    private final Queue<Node<S,A>> queue;

    public BreadthFirstSearch(final Problem<S,A> problem) {
        super(problem, true);
        queue = new LinkedList<>();
    }

    @Override
    protected void addToFrontier(final Node<S,A> node) {
        queue.offer(node);
    }

    @Override
    protected Node<S,A> removeFromFrontier() {
        return queue.poll();
    }

    @Override
    protected boolean isFrontierEmpty() {
        return queue.isEmpty();
    }

    public static final void main(final String[] args) {
        int[][] board = new int[][] {
                {5, 4, Puzzle8Board.EMPTY},
                {6, 1, 8},
                {7, 3, 2}
        };
        final Problem<Puzzle8Board, AdyacentMovement> puzzle8Problem = new PuzzleNProblem(board);
        final BreadthFirstSearch<Puzzle8Board, AdyacentMovement> bfs = new BreadthFirstSearch<>(puzzle8Problem);
        final Node<Puzzle8Board, AdyacentMovement> ans = bfs.search().get();
        System.out.println(ans);
        System.out.println(ans.getPathCost());
        System.out.println("Metrics: " + bfs.getMetrics());
    }
}
