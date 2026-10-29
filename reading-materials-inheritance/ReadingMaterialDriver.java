public class ReadingMaterialDriver {  //main method
    public static void main(String[] args) {
    	//Creates examples of each reading type 
        ReadingMaterial book = new Book("Schritte 1",198, "Hueber", "Daniela Niebisch");
        ReadingMaterial novel = new Novel("My Sweet Orange Tree", 192, "Pushkin Children's Books", "José Mauro de Vasconcelos", "Children's novel", new String[]{"Zeze", "Totoca"});
        ReadingMaterial magazine = new Magazine("Tech Trends Monthly", 120, "Future Media Inc.", "October 2024", "Sarah Johnson");
        ReadingMaterial journal = new TechnicalJournal("International Journal of Tennis Science", 150, "Sports Science Publications", "Sports Science and Tennis Performance", new String[]{"PubMed", "Scopus", "Web of Science"}, 3.2);
        ReadingMaterial textbook = new Textbook("Thomas'Calculus", 1052, "Pearson Education Limited", "Hass, Hail, Weir", "Math", 14);

        //calls printDetails() on each example to display the attributes for each type 
        System.out.println("BOOK");
        book.printDetails();
        System.out.println();
        
        System.out.println("NOVEL");
        novel.printDetails();
        System.out.println();
        
        System.out.println("MAGAZINE");
        magazine.printDetails();
        System.out.println();
        
        System.out.println("JOURNAL");
        journal.printDetails();
        System.out.println();
        
        System.out.println("TEXTBOOK");
        textbook.printDetails();
    }
}