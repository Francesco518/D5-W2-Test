package it.epicode.be;

public class Magazine extends Element {
    public enum Periodicity {
        WEEKLY, MONTHLY, HALF_YEARLY
    }

    private Periodicity periodicity;

    public Magazine(String isbn, String title, int year, int pages, Periodicity periodicity) {
        super(isbn, title, year, pages);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Periodicity: " + periodicity;
    }
}
