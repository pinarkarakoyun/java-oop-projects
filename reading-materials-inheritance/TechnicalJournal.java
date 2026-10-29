public class TechnicalJournal extends ReadingMaterial {
    private String scope;  //scope of the journal
    private String[] indexingList;  //array of indexing services where the journal is listed
    private double impactFactor;  //the journal’s impact factor

    public TechnicalJournal(String title, int numberOfPages, String publisher, String scope, String[] indexingList, double impactFactor) {
        super(title, numberOfPages, publisher);
        this.scope = scope;
        this.indexingList = indexingList;
        this.impactFactor = impactFactor;
    }

    @Override
    public void printDetails() {  //overrides printDetails to display scope, impact factor, and indexing list
        super.printDetails();
        System.out.println("Scope: " + scope);
        System.out.print("Indexing List: ");
        for (String index : indexingList) {  //the indexing list is displayed using a loop
            System.out.print(index + " ");
        }
        System.out.println();
        System.out.println("Impact Factor: " + impactFactor);
    }
}
