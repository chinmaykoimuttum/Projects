import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BookMapperBackend<KeyType, ValueType> implements IBookMapperBackend {

  public BEIterableMapADT hashTable = new BEIterableMapADT();
  String authorFilter = null;

  @Override
  /**
   * Adds a new book to the backend's database and is stored in
   * a hash table internally.
   * @param book the book to add
   */
  public void addBook(IBook book) {
    hashTable.put(book.getISBN13(), book);
    // TODO Auto-generated method stub
  }

  @Override
  /**
   * Returns the number of books stored in the backend's database.
   * @return the number of books
   */
  public int getNumberOfBooks() {
    // TODO Auto-generated method stub
    return hashTable.size();
  }

  @Override
  /**
   * This method can be used to set a filter for the author names
   * contained in the search results. A book is only returned as
   * a result for a search by title, it is also contains the string
   * filterBy in the names of its authors.
   * @param filterBy the string that the book's author names must contain
   */
  public void setAuthorFilter(String filterBy) {
    this.authorFilter = filterBy;
    // TODO Auto-generated method stub

  }

  @Override
  /**
   * Returns the string used as the author filter, null if no author
   * filter is currently set.
   * @return the string used as the author filter, or null if none is set
   */
  public String getAuthorFilter() {
    // TODO Auto-generated method stub
    return this.authorFilter;
  }

  @Override
  /**
   * Resets the author filter to null (no filter).
   */
  public void resetAuthorFilter() {
    // TODO Auto-generated method stub
    this.authorFilter = null;

  }

  /**
   * Search through all the books in the title base and return books whose title contains the string
   * word (and that satisfies the author filter, if an author filter is set).
   * 
   * @param word word that must be contained in a book's title in result set
   * @return list of books found
   */
  @Override
  public List<IBook> searchByTitleWord(String word) {
    // TODO Auto-generated method stub
    List<IBook> listBooks = new ArrayList<IBook>();
    Iterator<IBook> iter = hashTable.iterator();
    
    while (iter.hasNext()) {
      IBook currbook = iter.next();
      String title = currbook.getTitle();
     if (title.contains(word)) {
       listBooks.add(currbook);
     }
    }
    return listBooks;
   
  }

  /**
   * Return the book uniquely identified by the ISBN, or null if ISBN is not present in the dataset.
   * 
   * @param ISBN the book's ISBN number
   * @return the book identified by the ISBN, or null if ISBN not in database
   */
  @Override
  public IBook getByISBN(String ISBN) {
    // TODO Auto-generated method stub
   
    return hashTable.get(ISBN);
  }

  
  
  
}
