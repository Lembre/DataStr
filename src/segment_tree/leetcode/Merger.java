package segment_tree.leetcode;

public interface Merger<E> {
    E merge(E a, E b);
}
