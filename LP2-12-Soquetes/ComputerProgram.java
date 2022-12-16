public class ComputerProgram extends RecordedItem {
    protected float version;
    protected String platform;

    public ComputerProgram(int catalogueNumber, int numberOfCopies, String title, String medium, float version, String platform) {
        super(catalogueNumber, numberOfCopies, title, medium);
        this.version = version;
        this.platform = platform;
    }

    @Override
    public void acquire(){
    }

    @Override
    public void retornar(){
    }

    @Override
    public String toString() {
        return "Version: " + version + ", Platform: " + platform;
    }
}