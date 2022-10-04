public class MutableArray {
    private int size;
    private int capacity;
    private int[] pointer;
    
    public MutableArray() {
        size = 0;
        capacity = 2;
        pointer = new int[capacity];
    }

    public int capacity() {
        return this.capacity;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int at(int index) {
        if (index < 0 || index > this.size - 1) {
            System.out.println("Out of index");
        }
        return this.pointer[index];
    }

    public void push(int item) {
        if (this.size == capacity) {
            this.resize(capacity * 2);
        }
        this.pointer[this.size] = item;
        ++this.size;
    }

    public void insert(int item, int index) {
        if (index < 0 || index > this.size - 1) {
            System.out.println("Out of index");
            return;
        }
        if (this.size == capacity) {
            this.resize(capacity * 2);
        }
        for (int i = size; i > index; --i) { 
            this.pointer[i] = this.pointer[i - 1];
        }
        this.pointer[index] = item;
        ++this.size;
    }

    public void prepend(int item) {
        if (this.size == capacity) {
            this.resize(capacity * 2);
        }
        for (int i = this.size; i > 0; --i) {
            this.pointer[i] = this.pointer[i - 1];
        }
        this.pointer[0] = item;
        ++size;
    }

    public int pop() {
        if (this.isEmpty()) {
            System.out.println("No element found");
        }
        return this.pointer[this.size - 1];
    }

    public void removeItem(int item) {
        int index = this.find(item);
        for (int i = index; i < this.size - 1; ++i) {
            this.pointer[i] = this.pointer[i + 1];
        }
        --this.size;
    }

    public int find(int item) {
        for (int i = 0; i < this.size; ++i) {
            if (this.pointer[i] == item) {
                return i;
            }
        }
        return -1;
    }

    private void resize(int capacity) { 
        int[] copyArray = new int[capacity];
        for (int i = 0; i < this.size; ++i) {
            copyArray[i] = this.pointer[i];
        }
        this.pointer = copyArray;
        this.capacity = capacity;
    }

    public void println() {
        System.out.print("Current array: "); 
        for (int i = 0; i < this.size; ++i) {
            System.out.print(this.pointer[i] + " ");
        }
        System.out.println();
    }
}

class Test {
    public static void main(String[] args) {
        MutableArray mutableArray = new MutableArray();
        checkArray(mutableArray);
        mutableArray.push(1);
        checkArray(mutableArray);
        mutableArray.push(2);
        checkArray(mutableArray);
        mutableArray.push(3);
        checkArray(mutableArray);
        System.out.println("Pop: " + mutableArray.pop());
        checkArray(mutableArray);
        mutableArray.insert(-1, 1);
        checkArray(mutableArray);
        mutableArray.removeItem(-1);
        checkArray(mutableArray);
        mutableArray.prepend(0);
        checkArray(mutableArray);
        mutableArray.push(5);
        checkArray(mutableArray);
        System.out.println("[5]: " + mutableArray.at(5));
        checkArray(mutableArray);
    }

    public static void checkArray(MutableArray mutableArray) {
        System.out.println("=================================");
        System.out.println("Size: " + mutableArray.size());
        System.out.println("Capacity: " + mutableArray.capacity());
        mutableArray.println();
    }
}