import java.util.ArrayList;

public class MyHashMap<K, V> implements Map61B<K, V> {
    private int size;
    private int hashSize = 16;
    private double loadFactor = 0.75;
    private ArrayList<Item>[] list;
    public MyHashMap(int initial, double load){
        hashSize = initial;
        loadFactor = load;
        size = 0;
        list = new ArrayList[hashSize];
    }
    public void clear(){
        size = 0;
        list = null;
    }
    public int size(){
        return size;
    }
    public void put(K key, V value){
        if (size / hashSize >= loadFactor){
            ArrayList<Item>[] newList = new ArrayList[hashSize * 2];
            for (ArrayList<Item> items: list){
                for (Item item: items){
                    item.into(newList);
                }
            }
            list = newList;
        }
        Item newItem = new Item(key, value);
        newItem.into(list);
    }
    private class Item{
        K k;
        V v;
        Item(K a, V b){
            k = a;
            v = b;
        }
        void into(ArrayList<Item>[] list){

        }
    }
}
