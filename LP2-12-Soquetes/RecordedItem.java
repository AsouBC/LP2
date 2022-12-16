public class RecordedItem extends LibraryItem {
    protected String title, medium;

    public RecordedItem(int catalogueNumber, int numberOfCopies, String title, String medium){
        super(catalogueNumber, numberOfCopies);
        this.title = title;
        this.medium = medium;
    }

    @Override
    public void acquire(){
    }

    @Override
    public void retornar(){
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Medium: " + medium;
    }
}