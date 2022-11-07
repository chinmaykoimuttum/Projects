public class Book implements IBook{

  private String titleName;
  private String authorName;
  private String isbn13Number;

  public Book(String titleName, String authorName, String isbn13Number) {
    this.titleName = titleName;
    this.authorName = authorName;
    this.isbn13Number = isbn13Number;
  }

  @Override
  public String getTitle() {
    return titleName;
  }

  @Override
  public String getAuthors() {
    return authorName;
  }

  @Override
  public String getISBN13() {
    return isbn13Number;
  }

}
