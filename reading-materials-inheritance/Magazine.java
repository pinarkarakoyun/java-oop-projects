public class Magazine extends ReadingMaterial{  // represents a magazine type
    private String issue;  //issue of the magazine
    private String editor;  //name of the editor

    public Magazine(String title, int numberOfPages, String publisher, String issue, String editor){
        super(title, numberOfPages,publisher);  //initializes title, numberOfPages, and publisher using the base class constructor
        this.issue= issue;
        this.editor= editor;
    }

    @Override
    public void printDetails(){ //prints details of ReadingMaterial (title, pages, publisher) via super.printDetails() method
        super.printDetails();
        System.out.println("Issue: "+ issue);
        System.out.println("Editor: "+ editor);
    }
}
 