// --== CS400 Project One File Header ==--
// Name: Chinmay Koimuttum
// CSL Username: chinmay
// Email: koimuttum@wisc.edu 
// Lecture #: <002 @2:30pm>
// Notes to Grader: <any optional extra notes to your grader>

public class HashTableEntry<KeyType, ValueType> {
  private KeyType key;
  private ValueType value;
  
  public HashTableEntry(KeyType key, ValueType value) {
    this.key = key;
    this.value = value;
  }
  
  public KeyType getKey() {
    return key;
  }
  public void setKey(KeyType key) {
    this.key = key;
  }
  public ValueType getValue() {
    return value;
  }
  public void setValue(ValueType value) {
    this.value = value;
  }

}
