public interface Deque<type> {
    public int size();
    default public boolean isEmpty(){
        return size() == 0;
    }
    public type get(int index);
    public type removeFirst();
    public type removeLast();
    public void addFirst(type item);
    public void addLast(type item);
}
