public class PublishedItem extends LibraryItem{
    protected String title;
    protected String published;

    public PublishedItem(int catalogueNumber, int numberOfCopies, String title, String published){
        super(catalogueNumber, numberOfCopies);
        this.title=title;
        this.published=published;
    }

    @Override
    public String toString(){
        return super.toString() + "Title: " + this.title + ", Published: " + this.published + " ";
    }
}
