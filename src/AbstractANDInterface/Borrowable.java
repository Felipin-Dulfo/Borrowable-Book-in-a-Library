package AbstractANDInterface;

public interface  Borrowable {
    public void loan(int day);
    public void returned(int day);
    public double penalty();
}
