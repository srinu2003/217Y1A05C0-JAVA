import java.util.Arrays;

class openAddressingHash<T> {
    private final int size;
    T DEFAULT_VALUE = null;
    T hashTable[];
    int countTable[];
    int stateTable[];

    @SuppressWarnings("unchecked")
    public openAddressingHash(final int size, final T defaultValue) {
        this.size = size;
        DEFAULT_VALUE = defaultValue;
        hashTable = (T[]) new Object[size];
        countTable = new int[size];
        stateTable = new int[size];
        Arrays.fill(countTable, 0);
        Arrays.fill(stateTable, 0);
    }

    static int hashFunction(final int key, final int size) {
        // TODO: Implement hash function
        int hash = key % size;
        return hash;
    }

    public void insert(T value) {
        if (Arrays.stream(stateTable).sum() == size) {
            System.out.println("Hashmap is full");
            return;
        }

        int key = hashFunction(value.hashCode(), size);
        if (stateTable[key] == 0 || stateTable[key] == -1) {
            hashTable[key] = value;
            countTable[key]++;
            stateTable[key] = 1;
        } else if (stateTable[key] == 1) {
            while (stateTable[key] == 1) {
                if (hashTable[key].equals(value)) {
                    break;
                }
                key = (key + 1) % size;
            }
            hashTable[key] = value;
            countTable[key]++;
            stateTable[key] = 1;
        }
    }

    public void delete(T value) {
        if (noOfElements() == 0) {
            System.out.println("Hashmap is empty");
            return;
        }

        int key = search(value);
        if (key == -1) {
            System.out.println("Value not found");
            return;
        } else {
            hashTable[key] = null;
            countTable[key]--;
            stateTable[key] = (countTable[key] == 0) ? -1 : 0;
        }
    }

    public int search(T value) {
        int key = hashFunction(value.hashCode(), size);
        if (stateTable[key] == 0) {
            System.out.println("Value not found");
            return -1;
        } else if (stateTable[key] != 0) {
            if (hashTable[key] != null && hashTable[key].equals(value)) {
                return key;
            } else {
                int keyInitial = key;
                while (stateTable[key] != 0) {
                    key = (key + 1) % size;
                    if (key == keyInitial) {
                        System.out.println("Value not found");
                        return -1;
                    }
                    if (hashTable[key] != null && hashTable[key].equals(value)) {
                        return key;
                    }
                }
            }
        }
        return -1;
    }

    public int noOfElements() {
        return Arrays.stream(countTable).sum();
    }
}

public class GenericHash {
    public static void main(String[] args) {

        openAddressingHash<Integer> myMap = new openAddressingHash<Integer>(10, null);
        myMap.insert(7);
        myMap.insert(2);
        myMap.insert(17);
        myMap.insert(5);
        myMap.insert(5);
        System.out.println(myMap.search(7));
        // myMap.delete(7);
        // myMap.search(7);
        myMap.delete(17);
        System.out.println("myMap" + ":" + Arrays.toString(myMap.hashTable));
        System.out.println("myMap" + ":" + Arrays.toString(myMap.countTable));
        System.out.println("myMap" + ":" + Arrays.toString(myMap.stateTable));
    }
}
