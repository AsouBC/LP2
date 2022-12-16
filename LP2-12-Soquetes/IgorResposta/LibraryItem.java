public abstract class LibraryItem{
    protected int catalogueNumber;
    protected int numberOfCopies;

    public LibraryItem(int catalogueNumber, int numberOfCopies){
        this.catalogueNumber=catalogueNumber;
        this.numberOfCopies=numberOfCopies;
    }

    public void Acquire(){
        
    }

    public void Return(){

    }

    @Override
    public String toString(){
        return "Catalogue Number: " + this.catalogueNumber + " Number Of Copies: " + this.numberOfCopies + " ";
    }
}