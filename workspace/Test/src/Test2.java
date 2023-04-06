import components.sequence.Sequence;
import components.sequence.Sequence1L;

public abstract class Test2<T> implements Sequence<T> {

    @Override
    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public void flip() {
        Sequence<T> temp = new Sequence1L<>();
        for (int i = 0; i < this.length() - 1; i++) {
            T tempT = this.remove(i);
            temp.add(i, tempT);
        }
        this.transferFrom(temp);
    }
}
