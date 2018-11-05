package segment_tree.build_tree;

public interface Merger<E> {
    E merge(E a, E b);
}
