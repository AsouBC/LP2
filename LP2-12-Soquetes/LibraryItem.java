public abstract class LibraryItem {
    protected int catalogueNumber, numberOfCopies;

    public LibraryItem(int catalogueNumber, int numberOfCopies) {
        this.catalogueNumber = catalogueNumber;
        this.numberOfCopies = numberOfCopies;
    }

    public void acquire(){
    }

    public void retornar(){
    }

    public String toString() {
        return "CatalogueNumber: " + catalogueNumber + ", NumberOfCopies: " + numberOfCopies;
    }
}