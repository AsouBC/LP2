public class Film extends RecordedItem{
    protected String director;
    protected String dateOfRelease;
    protected String distribuitor;

    public Film(int catalogueNumber, int numberOfCopies, String title, String medium,String director, String dateOfRelease, String distribuitor){
        super(catalogueNumber, numberOfCopies, title, medium);
        this.director = director;
        this.dateOfRelease = dateOfRelease;
        this.distribuitor = distribuitor;
    }

    @Override
    public String toString(){
        return super.toString() + "Director: " + this.director + "Date of Release: " + this.dateOfRelease + " Distribuitor" + this.distribuitor + " ";
    
    }
}
