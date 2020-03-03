import org.jetbrains.annotations.NotNull;

public class ArrayDeque<type> {
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
    public void add(type i){
        if (size == array.length){
            resize(size * 2);
        }
        array[size] = i;
        size += 1;
    }
    public type remove(){
        type item = array[size];
        array[size] = null;
        size -= 1;
        return item;
    }
    public type get(int index){
        return array[index];
    }
    public int size(){
        return size;
    }
    public ArrayDeque(@NotNull ArrayDeque other){
        array = (type[]) new Object[other.size()];
        size = other.size;
        System.arraycopy(other, 0, array, 0, size);
    }
}
