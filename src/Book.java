import java.util.List;

public class Book {
    private String title;
    private List<Author> authorList;

    public Book(String title, List<Author> authorList) {
        this.title = title;
        this.authorList = authorList;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authorList=" + authorList +
                "}\n";
    }
}
