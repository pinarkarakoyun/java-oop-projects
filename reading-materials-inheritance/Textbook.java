public class Textbook extends Book {  //represents a textbook, a specific type of book
    private String subject; //subject of the textbook
    private int edition;  //edition number of the textbook

    public Textbook(String title, int numberOfPages, String publisher, String author, String subject, int edition) {
        super(title, numberOfPages, publisher, author);
        this.subject = subject;
        this.edition = edition;
        //calls the Book constructor to initialize attributes and adds subject and edition
    }

    @Override
    public void printDetails() {  //prints details of Book (subject and edition) via super.printDetails()
        super.printDetails();
        System.out.println("Subject: " + subject);
        System.out.println("Edition: " + edition);
    }
}
