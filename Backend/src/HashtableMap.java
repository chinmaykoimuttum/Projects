// --== CS400 Project One File Header ==--
// Name: Chinmay Koimuttum
// CSL Username: chinmay
// Email: koimuttum@wisc.edu 
// Lecture #: <002 @2:30pm>
// Notes to Grader: <any optional extra notes to your grader>

import java.util.NoSuchElementException;
import java.util.LinkedList;

public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {


  protected LinkedList<HashTableEntry<KeyType, ValueType>>[] hashTable;

  @SuppressWarnings("unchecked")
  public HashtableMap(int capacity) {
    hashTable = (LinkedList<HashTableEntry<KeyType, ValueType>>[]) new LinkedList[capacity];
    for (int i = 0; i < hashTable.length; i++) {
      hashTable[i] = new LinkedList<HashTableEntry<KeyType, ValueType>>();
    }

  }

  @SuppressWarnings("unchecked")
  public HashtableMap() {
    hashTable = (LinkedList<HashTableEntry<KeyType, ValueType>>[]) new LinkedList[15];
    for (int i = 0; i < hashTable.length; i++) {
      hashTable[i] = new LinkedList<HashTableEntry<KeyType, ValueType>>();
    }
  }

  /**
   * Inserts a new (key, value) pair into the map if the map does not
   * contain a value mapped to key yet.
   * 
   * @param key the key of the (key, value) pair to store
   * @param value the value that the key will map to
   * @return true if the (key, value) pair was inserted into the map,
   *         false if a mapping for key already exists and the
   *         new (key, value) pair could not be inserted
   */
  @Override
  public boolean put(KeyType key, ValueType value) {

    if (key == null || value == null || containsKey(key)) {
      return false;
    }

    HashTableEntry<KeyType, ValueType> entry = new HashTableEntry<KeyType, ValueType>(key, value);
    int index = Math.abs(key.hashCode()) % hashTable.length;
    hashTable[index].add(entry);
    float loadFactor = (float) size() / hashTable.length;

    if (loadFactor > 0.7 || (Float.compare(loadFactor, (float) 0.7)==0)) {
      int newLength = hashTable.length * 2;
      LinkedList<HashTableEntry<KeyType, ValueType>>[] newHashTable =
          (LinkedList<HashTableEntry<KeyType, ValueType>>[]) new LinkedList[newLength];

      for (int i = 0; i < newHashTable.length; i++) {
        newHashTable[i] = new LinkedList<HashTableEntry<KeyType, ValueType>>();
      }

      for (int i = 0; i < hashTable.length; i++) {
        for (int j = 0; j < hashTable[i].size(); j++) {
          if (hashTable[i] != null && hashTable[i].peekFirst() != null) {
            int newIndex = Math.abs(hashTable[i].get(j).getKey().hashCode()) % newHashTable.length;
            newHashTable[newIndex].add(hashTable[i].get(j));
          }
        }
      }
      hashTable = newHashTable;
    }

    return true;
  }

  /**
   * Returns the value mapped to a key if the map contains such a mapping.
   * 
   * @param key the key for which to look up the value
   * @return the value mapped to the key
   * @throws NoSuchElementException if the map does not contain a mapping
   *                                for the key
   */
  @Override
  public ValueType get(KeyType key) throws NoSuchElementException {
    // TODO Auto-generated method stub
    if (key == null || containsKey(key) != true) {
      throw new NoSuchElementException("key does not exist");
    }
    for (int i = 0; i < hashTable.length; i++) {
      if (hashTable[i].peekFirst() != null) {
        for (int j = 0; j < hashTable[i].size(); j++) {
          if (hashTable[i].get(j).getKey().equals(key)) {
            return hashTable[i].get(j).getValue();
          }
        }
      }
    }
    return null;
  }

  /**
   * Removes a key and its value from the map. 
   * 
   * @param key the key for the (key, value) pair to remove
   * @return the value for the (key, value) pair that was removed,
   *         or null if the map did not contain a mapping for key
   */
  @Override
  public ValueType remove(KeyType key) {
    // TODO Auto-generated method stub
    if (key == null || containsKey(key) != true) {
      return null;
    }
    for (int i = 0; i < hashTable.length; i++) {
      if (hashTable[i].peekFirst() != null) {
        for (int j = 0; j < hashTable[i].size(); j++) {
          if (hashTable[i].get(j).getKey().equals(key)) {
            return hashTable[i].remove(j).getValue();
          }
        }
      }
    }
    return null;
  }

  /**
   * Checks if a key is stored in the map.
   * 
   * @param key the key to check for
   * @return true if the key is stored (mapped to a value) by the map
   *         and false otherwise
   */
  @Override
  public boolean containsKey(KeyType key) {
    // TODO Auto-generated method stub
    for (int i = 0; i < hashTable.length; i++) {
      if (hashTable[i].peekFirst() != null) {
        for (int j = 0; j < hashTable[i].size(); j++) {
          if (hashTable[i].get(j).getKey().equals(key)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * Returns the number of (key, value) pairs stored in the map.
   * 
   * @return the number of (key, value) pairs stored in the map
   */
  @Override
  public int size() {
    int size = 0;
    for (int i = 0; i < hashTable.length; i++) {
      if (hashTable[i].peekFirst() != null) {
        for (int j = 0; j < hashTable[i].size(); j++) {
          size++;
        }
      }
    }

    return size;
  }

  /**
   * Removes all (key, value) pairs from the map.
   */
  @Override
  public void clear() {
    for (int i = 0; i < hashTable.length; i++) {
      if (hashTable[i].peekFirst() != null) {
        for (int j = 0; j < hashTable[i].size(); j++) {
          hashTable[i].remove(j);
        }
      }
    }
  }


}
