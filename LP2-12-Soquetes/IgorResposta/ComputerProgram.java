public class ComputerProgram extends RecordedItem{
    protected int version;
    protected String platform;

    public ComputerProgram(int catalogueNumber, int numberOfCopies, String title, String medium, int version, String platform) {
        super(catalogueNumber, numberOfCopies, title, medium);
        this.version = version;
        this.platform = platform;
    }

    @Override
    public String toString() {
        return super.toString() + "Version: " + this.version + ", Platform: " + this.platform + " ";
    }
}
