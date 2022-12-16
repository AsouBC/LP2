public class PublishedItem extends LibraryItem {
    protected String title, publisher;

    public PublishedItem(int catalogueNumber, int numberOfCopies, String title, String publisher){
        super(catalogueNumber, numberOfCopies);
        this.title = title;
        this.publisher = publisher;
    }

    @Override
    public void acquire(){
    }

    @Override
    public void retornar(){
    }

    @Override
    public String toString() {
        return "CatalogueNumber: " + catalogueNumber + ", NumberOfCopies: " + numberOfCopies + ", Title: " + title + ", Publisher: " + publisher;
    }
}
