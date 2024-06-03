package org.example.util.ds;

public class HashMap<K, V> {

    private class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int n; // total number of node
    private int N; // total number of buckets
    private LinkedList<Node> buckets[];

    @SuppressWarnings("unchecked")
    public HashMap() {
        this.N = 4;
        this.buckets = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(K key) {
        int bi = key.hashCode();
        return Math.abs(bi) % N;
    }

    private int searchInLL(K key, int bucketIndex) {
        LinkedList<Node> ll = buckets[bucketIndex];
        int di = 0;
        for (int i = 0; i < ll.getSize(); i++) {
            Node currentKey = ll.get(i);
            if (currentKey == null) {
                return -1;
            }

            if (currentKey.key == key) {
                return i;
            }
        }

        return -1;
    }

    private void reHash() {
        LinkedList<Node>[] oldBucket = this.buckets;
        buckets = new LinkedList[N * 2];
        for (int i = 0; i < N * 2; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (LinkedList<Node> ll : oldBucket) {
            for (int j = 0; j < ll.getSize(); j++) {
                Node node = ll.get(j);
                put(node.key, node.value);
            }
        }
    }


    public void put(K key, V value) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInLL(key, bucketIndex); // di = 
        if (dataIndex == -1) {
            buckets[bucketIndex].addFirst(new Node(key, value));
            n++;
        } else {
            Node data = buckets[bucketIndex].get(dataIndex);
            data.value = value;
        }

        double lambda = (double) n / N;
        if (lambda > 2.0) {
            // reHashing
            reHash();
        }


    }


    public V get(K key) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInLL(key, bucketIndex);

        if (dataIndex == -1) {
            System.out.println("Key doesnot exist");
            return null;
        }
        Node node = this.buckets[bucketIndex].get(dataIndex);
        return node.value;

    }


    public boolean containsKey(K key) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInLL(key, bucketIndex);

        if (dataIndex == -1) {
            System.out.println("Key doesnot exist");
            return false;
        }
        return true;
    }

    public V remove(K key) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInLL(key, bucketIndex);

        if (dataIndex == -1) {
            System.out.println("Key doesn't exist");
            return null;
        }
        Node node = this.buckets[bucketIndex].get(dataIndex);
        Node removedNode = this.buckets[bucketIndex].remove(dataIndex);
        System.out.println("test" + removedNode);
        return removedNode.value;
    }


}
