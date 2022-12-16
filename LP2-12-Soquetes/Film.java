public class Film extends RecordedItem {
    protected String director, dateRelease, distributor;

    public Film(int catalogueNumber, int numberOfCopies, String title, String medium, String director, String dateRelease, String distributor) {
        super(catalogueNumber, numberOfCopies, title, medium);
        this.director = director;
        this.dateRelease = dateRelease;
        this.distributor = distributor;
    }

    @Override
    public void acquire(){
    }

    @Override
    public void retornar(){
    }

    @Override
    public String toString() {
        return "Director: " + director + ", DateRelease: " + dateRelease + ", Distributor: " + distributor;
    }
}
