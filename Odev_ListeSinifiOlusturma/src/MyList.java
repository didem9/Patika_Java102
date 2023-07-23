import java.util.Arrays;

public class MyList<T> {
    private T[] array;
    private int capacity = 10;

    // ALL ARGS - NO ARGS CONSTRUCTORS

    public MyList(){
        this.array = (T[]) new Object[this.capacity];
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[this.capacity];
    }

    // GETTER and SETTER
    public T[] getArray() {

        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public int getCapacity() {

        return capacity;
    }

    public void setCapacity(int capacity) {

        this.capacity = capacity;
    }

    public int size(){                  // DİZİNİN ELEMAN SAYISI
        int counter = 0;
        for(int i = 0; i < getCapacity(); i++){
            if (array[i] != null){
                counter++;
            }
        }
        return counter;
    }

    public void add(T data){
        if(size() == this.capacity){
            this.capacity *= 2;                                 // KAPASİTE ARTIŞI
            array = Arrays.copyOf(array, this.capacity);        // MEVCUT DİZİYİ KOPYALAMA
        }
        array[size()] = data;                                   // DİZİYE ELEMAN EKLEME
    }

    public T get(int index){
        if(index < 0 || index >= this.capacity) {
            return null;
        }
        return array[index];
    }
    public T remove(int index){
        if(index < 0 || index >= this.capacity) {
            return null;
        }
            T removed = array[index];
            array[index] = null;
            for(int i = index + 1; i == size() - 1; i++){
                array[i - 1] = getArray()[i];
            }
        array[size() - 1] = null;
        return removed;
    }

    public T set(int index, T data){
        if (getArray()[index] != null){
            getArray()[index] = data;
            return data;
        }
        return null;
    }

    public String toString(){
        String list = "[";
        for(T element : getArray()){
            if(element != null){
                list = list + element + ",";
            }else{
                list = list + "]";
                break;
            }
        }
        return list;
    }

    public int indexOf(T data){
        for (int i = 0; i < array.length; i++){
            if (data.equals(array[i]))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(T data){
        for (int i = array.length - 1; i >=0  ; i--){
            if (data.equals(array[i]))
                return i;
        }
        return -1;
    }

    public boolean isEmpty(){
        for(int i =0 ; i < array.length; i++){
            if (array[i] != null){
                return false;
            }
        }
        return true;
    }

    public T[] toArray(){
        T[] newArray = (T[]) new Object[getCapacity()];
        for(int i = 0; i < this.array.length; i++){
            newArray[i] = array[i];
        }
        return newArray;
    }

    public void clear() {
        Arrays.fill(array, null);
       // int size = 0;
    }

    public MyList<T> subList(int start, int finish){

        if(start < 0 || start >= finish) {
            throw new IllegalArgumentException("Invalid sublist range");
        }
        MyList<T> myListNew = new MyList<>();
        for (int i = start; i < finish; i++) {
            if (array[i] != null) {
             myListNew.add(get(i));
            }
        }
        return myListNew;
    }

    boolean contains(T data){
        for (int i = 0; i <= size(); i++){
            if(array[i] == data){
                return true;
            }
        }return false;
    }

}










