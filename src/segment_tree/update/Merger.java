package segment_tree.update;

public interface Merger<E> {
    E merge(E a, E b);
}
