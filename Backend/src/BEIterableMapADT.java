import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class BEIterableMapADT implements IterableMapADT<String, IBook> {

  protected LinkedList<HashTableEntry<String, IBook>>[] hashTable;

  @SuppressWarnings("unchecked")
  public BEIterableMapADT(int capacity) {
    hashTable = (LinkedList<HashTableEntry<String, IBook>>[]) new LinkedList[capacity];
    for (int i = 0; i < hashTable.length; i++) {
      hashTable[i] = new LinkedList<HashTableEntry<String, IBook>>();
    }

  }
  
  @SuppressWarnings("unchecked")
  public BEIterableMapADT() {
    hashTable = (LinkedList<HashTableEntry<String, IBook>>[]) new LinkedList[15];
    for (int i = 0; i < hashTable.length; i++) {
      hashTable[i] = new LinkedList<HashTableEntry<String, IBook>>();
    }
  }
  
  @Override
  public boolean put(String isbn, IBook book) {
    // TODO Auto-generated method stub
    if (isbn == null || book == null || containsKey(isbn)) {
      return false;
    }

    HashTableEntry<String, IBook> entry = new HashTableEntry<String, IBook>(isbn, book);
    int index = Math.abs(isbn.hashCode()) % hashTable.length;
    hashTable[index].add(entry);
    float loadFactor = (float) size() / hashTable.length;

    if (loadFactor > 0.7 || (Float.compare(loadFactor, (float) 0.7)==0)) {
      int newLength = hashTable.length * 2;
      LinkedList<HashTableEntry<String, IBook>>[] newHashTable =
          (LinkedList<HashTableEntry<String, IBook>>[]) new LinkedList[newLength];

      for (int i = 0; i < newHashTable.length; i++) {
        newHashTable[i] = new LinkedList<HashTableEntry<String, IBook>>();
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

  @Override
  public IBook get(String isbn) throws NoSuchElementException {
    if (isbn == null || containsKey(isbn) != true) {
      throw new NoSuchElementException("key does not exist");
    }
    for (int i = 0; i < hashTable.length; i++) {
      if (hashTable[i].peekFirst() != null) {
        for (int j = 0; j < hashTable[i].size(); j++) {
          if (hashTable[i].get(j).getKey().equals(isbn)) {
            return hashTable[i].get(j).getValue();
          }
        }
      }
    }
    return null;
    // TODO Auto-generated method stub
  }

  @Override
  public IBook remove(String isbn) {
    // TODO Auto-generated method stub
    if (isbn == null || containsKey(isbn) != true) {
      return null;
    }
    for (int i = 0; i < hashTable.length; i++) {
      if (hashTable[i].peekFirst() != null) {
        for (int j = 0; j < hashTable[i].size(); j++) {
          if (hashTable[i].get(j).getKey().equals(isbn)) {
            return hashTable[i].remove(j).getValue();
          }
        }
      }
    }
    return null;

  }

  @Override
  public boolean containsKey(String isbn) {
    // TODO Auto-generated method stub
    if (isbn == null) {
      return false;
    }
    for (int i = 0; i < hashTable.length; i++) {
      if (hashTable[i].peekFirst() != null) {
        for (int j = 0; j < hashTable[i].size(); j++) {
          if (hashTable[i].get(j).getKey().equals(isbn)) {
            return true;
          }
        }
      }
    }
    return false;

  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
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

  @Override
  public void clear() {
    // TODO Auto-generated method stub
    
    
  }
//return List.iterator, list as field in class
  public Iterator<IBook> iterator() {
    List<IBook> test = new ArrayList<IBook>();
    IBook testBook = new Book("Bill Bryson's African Diary", "Bill Bryson", "9780767915069");
    IBook testBook2 = new Book("In a Sunburned Country", "Bill Bryson", "9780767903868");
 
    test.add(testBook2);
    test.add(testBook);
    Iterator<IBook> iter = test.iterator();
    
 
    // TODO Auto-generated method stub
    return iter;
  }

}
