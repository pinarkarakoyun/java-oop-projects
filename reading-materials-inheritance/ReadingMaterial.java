public class ReadingMaterial {  //Base class
    private String title;  //title of the reading material
    private int numberOfPages;  //total number of pages
    private String publisher;  //name of the publisher

    
    //this constructor initializes the three attributes (title, numberOfPages, and publisher) when an instance is created
    public ReadingMaterial(String title, int numberOfPages, String publisher){
        this.title= title;
        this.numberOfPages= numberOfPages;
        this.publisher= publisher;
    }
    
    
    //prints out details of the reading material, such as title, number of pages, and publisher
    public void printDetails(){
        System.out.println("Title: " + title);
        System.out.println("Number of Pages: "+ numberOfPages);
        System.out.println("Publisher: "+ publisher);
    }
}
