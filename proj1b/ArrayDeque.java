
public class ArrayDeque<type> implements Deque<type>{
    private type[] array;
    private int size;
    public ArrayDeque(){
        array = (type[]) new Object[8];
        size = 0;
    }
    public void resize(int capacity){
        type[] newArray = (type[]) new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
    public void addLast(type i){
        if (size == array.length){
            resize(size * 2);
        }
        array[size] = i;
        size += 1;
    }
    public void addFirst(type item){
        if (size == array.length){
            resize(size * 2);
        }
        if (size > 0) System.arraycopy(array, 0, array, 1, size);
        array[0] = item;
    }
    public type removeLast(){
        type item = array[size - 1];
        array[size - 1] = null;
        size -= 1;
        return item;
    }
    public type removeFirst(){
        type item = array[0];
        for (int i = 0;i < size - 1;i += 1){
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size -= 1;
        return item;
    }
    public type get(int index){
        return array[index];
    }
    public int size(){
        return size;
    }
    public ArrayDeque(ArrayDeque other){
        array = (type[]) new Object[other.size()];
        size = other.size;
        System.arraycopy(other, 0, array, 0, size);
    }
}
