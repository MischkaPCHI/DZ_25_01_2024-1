import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        /*
        Допустим, у вас есть список строк вида: “Jack:in”, “John:in”, “Jack:out”, “Lena:in”,“John:out”.
        Каждая строка означает, что сотрудник зашел (in) или вышел (out) из офиса.
        Необходимо написать метод который вернет список имен сотрудников, которые находяться в офисе.
         */
        List<String> peopleStr = new ArrayList<>();

        peopleStr.add("Jack:in");
        peopleStr.add("John:in");
        //peopleStr.add("Jack:out");
        peopleStr.add("Lena:in");
        peopleStr.add("John:out");


        System.out.println(getCurrentlyInOffice(peopleStr));

        /*
        Предположим, что дан список Book {String title, List<Author> authors} ,
        Author – класс {String fName, String lName} Необходимо сформировать map<Author, List<Book>>,  где ключ - автор,
        а значение список его книг. Естественно, если у книги несколько авторов,
        то книга должна отразиться в списке книг всех авторов данной книги.
         */


        List<Book> books = new ArrayList<>();
        Author author1 = new Author("Christopher", "Paolini");


        books.add(new Book("Eragon1 ", new ArrayList<>(List.of(new Author("Christopher", "Paolini")))));
        books.add(new Book("Eragon2 ", new ArrayList<>(List.of(new Author("Christopher", "Paolini")))));
        books.add(new Book("Eragon3 ", new ArrayList<>(List.of(new Author("Christopher", "Paolini")))));
        books.add(new Book("Eragon4 ", new ArrayList<>(List.of(new Author("Christopher", "Paolini")))));
        books.add(new Book("Вечера на хуторе близ диканьки ", new ArrayList<>(List.of(new Author("Николай", "Гоголь")))));
        System.out.println(books);



        Map<Author,List<Book>> mapAuthor = new HashMap<>();

        for (Book book : books){
            for (Author author : book.getAuthorList()){
                mapAuthor.computeIfAbsent(author, list -> new ArrayList<>()).add(book);
            }
        }
        System.out.println(mapAuthor);
    }
    public static List<Map.Entry<String, String>> getCurrentlyInOffice(List<String> peopleStr){
        Map<String, String> map = new HashMap<>();
        List<Map.Entry<String, String>> currentlyInOffice = new ArrayList<>();

        for (String str : peopleStr) {
            String[] split = str.split(":");
            if (split.length == 2) {
                String name = split[0];
                String inOrOut = split[1];
                map.put(name,inOrOut);
            }
        }
        for (Map.Entry<String, String> entry: map.entrySet()){
            if(entry.getValue().equals("in")) {
                currentlyInOffice.add(entry);
            }
        }
        return currentlyInOffice;
    }
}