public class Novel extends Book {
    private String genre;  //the genre of the novel
    private String[] mainCharacters;  //array containing names of main characters

    public Novel(String title, int numberOfPages,String publisher, String author, String genre, String[] mainCharacters){
        super(title,numberOfPages, publisher, author);  //calls the Book superclass constructor 
        this.genre= genre;  //initializes genre
        this.mainCharacters= mainCharacters;  //initializes mainCharacters
    }

    @Override
    public void printDetails(){  //overrides printDetails() to display genre and main characters
        super.printDetails();
        System.out.println("Genre: "+genre);
        System.out.println("Main Characters: ");
        for (String character: mainCharacters){
            System.out.println(character+ " ");
        }
    }
}