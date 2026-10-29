public class Book extends ReadingMaterial {
    private String author;

    public Book(String title, int numberOfPages, String publisher, String author){
        super(title, numberOfPages, publisher);
        this.author= author;
    }
    @Override
    public void printDetails(){
        super.printDetails();
        System.out.println("Author: "+ author);
    }
}
