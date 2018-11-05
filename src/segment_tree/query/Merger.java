package segment_tree.query;

public interface Merger<E> {
    E merge(E a, E b);
}
