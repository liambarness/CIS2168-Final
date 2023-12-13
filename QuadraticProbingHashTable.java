public class QuadraticProbingHashTable {
    private Integer[] hashTable;
    private int tableSize;

    public QuadraticProbingHashTable(int size) {
        tableSize = size;
        hashTable = new Integer[tableSize];
    }

    private int hashFunction(int key) {
        return key % tableSize;
    }

    private int quadraticProbing(int key, int i) {
        return (hashFunction(key) + i * i) % tableSize;
    }

    public boolean insert(int key) {
        for (int i = 0; i < tableSize; i++) {
            int index = quadraticProbing(key, i);
            if (hashTable[index] == null) {
                hashTable[index] = key;
                return true;
            }
        }
        return false; // Table is full
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tableSize; i++) {
            if (hashTable[i] != null) {
                sb.append("Index ").append(i).append(": ").append(hashTable[i]).append("\n");
            } else {
                sb.append("Index ").append(i).append(": ").append("null").append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        QuadraticProbingHashTable hashTable = new QuadraticProbingHashTable(7);
        int[] values = {20, 21, 2, 15, 7, 8};

        for (int value : values) {
            hashTable.insert(value);
        }

        System.out.println(hashTable.toString());
    }
}
