public class RecordedItem extends LibraryItem {
    protected String title;
    protected String medium;
   
   public RecordedItem(int catalogueNumber, int numberOfCopies, String title, String medium) {
        super(catalogueNumber, numberOfCopies);
        this.title = title;
        this.medium = medium;
   }

   @Override
   public String toString() {
       return super.toString() + "Title: " + this.title + ", Medium: " + this.medium + " ";
   }
}
