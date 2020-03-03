public class LinkedListDeque<type> implements Deque<type>{
    private Linknode sentinal = new Linknode(null, null);
    private int size;
    //private Linknode last;
//    public LinkedListDeque(type i){
//        sentinal.next = new Linknode(i, null);
//        sentinal.item = null;
//    }
    public LinkedListDeque(){
        sentinal.item = null;
        sentinal.prev = sentinal;
        sentinal.next = sentinal;
        size = 0;
    }
    public boolean isEmpty(){
        boolean t = (size == 0);
        return t;
    }
    public void addFirst(type t){
        Linknode n = new Linknode(t, sentinal.next);
        sentinal.next.prev = n;
        sentinal.next = n;
        n.prev = sentinal;
        if (size ==0){
            sentinal.prev = n;
        }
        size += 1;
    }
    public void addLast(type t){
        Linknode n = new Linknode(t, sentinal);
        n.prev = sentinal.prev;
        sentinal.prev.next = n;
        sentinal.prev = n;
        size += 1;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        Linknode i = sentinal.next;
        while (i.item != null){
            System.out.print(i.item);
            i = i.next;
        }
        System.out.println();
    }
    public type removeFirst(){
        Linknode i = sentinal.next;
        if (i == sentinal){
            return null;
        }
        sentinal.next = i.next;
        i.next.prev = sentinal;
        size -= 1;
        return i.item;
    }
    public type removeLast(){
        Linknode i = sentinal.prev;
        if (i == sentinal){
            return null;
        }
        sentinal.prev = i.prev;
        i.prev.next = sentinal;
        size -= 1;
        return i.item;
    }
    public type get(int index){
        Linknode i = sentinal.next;
        if (index >= size){
            return null;
        }
        while (index > 0){
            i = i.next;
            index -=1;
        }
        return i.item;
    }
    public LinkedListDeque(LinkedListDeque old){
        //LinkedListDeque l = new LinkedListDeque();
        int t = old.size();
        int i = 0;
        while (t > 0){
            this.addLast((type) old.get(i));
            i += 1;
            t -= 1;
        }
    }
    public class Linknode{
        public Linknode prev;
        public type item;
        public Linknode next;
        public Linknode(type i, Linknode n){
            item = i;
            next = n;
        }
    }
}
