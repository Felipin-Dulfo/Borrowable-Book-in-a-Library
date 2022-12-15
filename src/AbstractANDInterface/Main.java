package AbstractANDInterface;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);

	    Book book = new Book(in.nextLine(), in.nextLine(), in.next(), in.nextInt());

	    book.loan(in.nextInt());
	    book.returned(in.nextInt());

	    System.out.println(book.toString());
    }
}
