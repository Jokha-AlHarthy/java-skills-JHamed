public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("1960", "Ahmed Al-Harthy", 333);
        Book book2 = new Book("1980", "Mohammed Al-Harthy", 343);
        Textbook textbook = new Textbook("Java Programming", "Ali Al-Harthy", 999, "Computer Science", 4);

        // Test borrowing and returning
        book1.borrowBook();
        book1.borrowBook();
        book1.returnBook();
        book1.borrowBook();


        // Display information for all books
        book1.displayInfo();
        book2.displayInfo();
        textbook.displayInfo();



    }
}
