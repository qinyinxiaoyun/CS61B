import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
//    assert K extends comparable;
    private int size;
    private treeMap tree;

    public BSTMap(){
        size = 0;
        tree = null;
    }
    public void clear(){
        size = 0;
        tree = null;
    }
    public int size(){
        return size;
    }
    public void put(K k, V v) {
        tree = append(tree, k, v);
        size += 1;
    }
    private treeMap append(treeMap t, K k, V v){
        if (t == null){
            t = new treeMap(k,v);
            return t;
        }
        int i = k.compareTo(t.key);
        if (i < 0){
            t.left = append(t.left, k, v);
        }
        else {
            t.right = append(t.right, k, v);
        }
        return t;
    }
    public V get(K k){
        return got(tree, k);
    }
    private V got(treeMap t, K k){
        if (t == null){
            return null;
        }
        int i = k.compareTo(t.key);
        if (k == t.key){
            return t.value;
        }
        else if (i < 0){
            return got(t.left, k);
        }
        else {
            return got(t.right, k);
        }
    }
    public boolean containsKey(K key){
        if (key == null){
            throw new IllegalArgumentException("key can not be null");
        }
        return get(key) != null;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }
    public V remove(K k){
        throw new UnsupportedOperationException();
    }
    public V remove(K k, V v){
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    class treeMap{
        K key;
        V value;
        treeMap left;
        treeMap right;
        treeMap(K a, V b){
            key = a;
            value = b;
        }
//        public void expend(K k, V v){
//            if (this == null){
//                this = new treeMap(k, v);
//            }
//            else if (k < t.key){
//                append(t.left, k, v);
//            }
//            else {
//                append(t.right, k, v);
//            }
//        }
    }
}
