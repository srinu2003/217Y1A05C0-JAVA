import java.util.Arrays;

// H(x) = h0(x) + h1(x) + h2(x) + ...) mod M
// Size := M


class opAHash {
    private final int size;
    int DEFAULT_VALUE = 0;
    int hashTable[];
    int countTable[];
    int stateTable[];

    public opAHash(final int size) {
        this.size = size;
        hashTable = new int[size]; 
        countTable = new int[size]; 
        stateTable = new int[size];
        Arrays.fill(countTable, 0);
        Arrays.fill(stateTable, 0);
    }
    static int hashFunction(final int key, final int size){
        // TODO: Implement hash function
        return key % size; //return Value
    }
    public void insert(int key) {
        if (Arrays.stream(stateTable).sum() == size) {
            System.out.println("Hashmap is full");
            return;
        }

        int value = hashFunction(key, size);
        if (stateTable[value] == 0 || stateTable[value] == -1) {
            hashTable[value] = key;
            countTable[value]++;
            stateTable[value] = 1;
        } else if (stateTable[value] == 1) {
            while (stateTable[value] == 1) {
                if (hashTable[value] == key) {
                    break;
                }
                value = (value + 1) % size;
            }
            hashTable[value] = key;
            countTable[value]++;
            stateTable[value] = 1;
        }
    }

    public void delete(int key) {
        if (noOfElements() == 0){
            System.out.println("Hashmap is empty");
            return;
        }

        int value = search(key);
        if (value == -1) {
            System.out.println("Value not found");
            return;
        } else {
            hashTable[value] = DEFAULT_VALUE;
            countTable[value]--;
            stateTable[value] = (countTable[value] == 0) ? -1 : 0;
        }
    }

    public int search(int key) {
        int value = hashFunction(key, size);
        if (stateTable[value] == 0) {
            System.out.println("Value not found");
            return -1;
        } else if (stateTable[value] != 0){
            if (hashTable[value] == key) {
                return value;
            } else {
                int valueInitial = value;
                while (stateTable[value] != 0) {
                    value = (value + 1) % size;
                    if(value == valueInitial){
                        System.out.println("Value not found");
                        return -1;
                    }
                    if (hashTable[value] == key) { return value; }
                }
            }
        }
        return -1;
    }

    public int noOfElements() {
        return Arrays.stream(countTable).sum();
    }
}

public class HashMain {

    public static void main(String[] args) {

        opAHash myMap = new opAHash(10);
        myMap.insert(7);
        myMap.insert(2);
        myMap.insert(17);
        myMap.insert(5);
        System.out.println(myMap.search(7));
        // myMap.delete(7);
        // myMap.search(7);
        myMap.delete(17);
        System.out.println("myMap"+":"+Arrays.toString(myMap.hashTable));
        System.out.println("myMap"+":"+Arrays.toString(myMap.countTable));
        System.out.println("myMap"+":"+Arrays.toString(myMap.stateTable));
    }
}
