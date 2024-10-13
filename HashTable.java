import java.util.LinkedList;

class HashTable<K, V> {
    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] table;
    private int size;


    public HashTable() {
        table = new LinkedList[10];
        size = 0;
    }


    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }


    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<Entry<K, V>>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<K, V>(key, value));
        size++;
    }


    public V get(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return null;
        }


        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }


    public void remove(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return;
        }


        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove != null) {
            table[index].remove(toRemove);
            size--;
        }
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.put("Иван", 1);
        hashTable.put("Андрей", 2);
        hashTable.put("Катя", 3);

        System.out.println("Размер: " + hashTable.size()); // 3
        System.out.println("Значение Ивана: " + hashTable.get("Иван")); // 1
        System.out.println("Значчение Андрея: " + hashTable.get("Андрей")); // 2

        hashTable.remove("Иван");
        System.out.println("После удаления Ивана: " + hashTable.get("Иван")); // null

        System.out.println("Размер после удаления: " + hashTable.size()); // 2
        System.out.println("Проверка на пустоту: " + hashTable.isEmpty()); // false

        System.out.println("Значение кати до изменения: " + hashTable.get("Катя"));
        hashTable.put("Катя", 5);
        System.out.println("Значение кати после изменения: " + hashTable.get("Катя"));

    }
}
