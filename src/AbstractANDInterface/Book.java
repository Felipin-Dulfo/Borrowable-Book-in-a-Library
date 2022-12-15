package AbstractANDInterface;

public class Book implements Borrowable{
    String title;
    String author; // we are keeping this simple, no Person for now
    String ISBN;
    int yearPublished;
    boolean onLoan;
    int loanedMonth; // This is always set to 1
    int loanedDay; // range (1 - 31)
    int loanedYear; // This is always set to 2020
    int returnedMonth; // This is always set to 1
    int returnedDay; // range (1 - 31) and is always greater than loanedDay
    int returnedYear; // This is always set to 2020
    int daysAllowedOnLoan; // uniform for all Book Borrowables set to 5 days
    double dailyPenaltyCost; // this should be set to 15 pesos for all Book Borrowables

    Book(String title, String author, String ISBN, int yearPublished){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;

        loanedMonth = 1;
        loanedYear = 2020;
        returnedMonth = 1;
        returnedYear = 2020;
        daysAllowedOnLoan = 5;
        dailyPenaltyCost = 15;

    }


    public void loan(int day) {
        this.loanedDay = day;
        this.onLoan = true;

    }


    public void returned(int day) {
        this.returnedDay = day;
        this.onLoan = false;

    }


    public double penalty() {
        double penalty = 0;
        int calculateDaysSpan = this.returnedDay - this.loanedDay;

        if(calculateDaysSpan > this.daysAllowedOnLoan) {

            calculateDaysSpan-=this.daysAllowedOnLoan;

            for (int i = 1; i <= calculateDaysSpan; i++) {
                penalty = i * this.dailyPenaltyCost;
            }
        }

        return penalty;
    }

    public String toString(){
        String newLoanedMonth = "";
        String newLoanedDay = "";
        String newReturnedMonth = "";
        String newReturnedDay = "";

        if(this.loanedMonth < 10 && this.loanedMonth > 0){
            newLoanedMonth = String.format("%02d", loanedMonth);
        }
        if(this.loanedMonth > 9 && this.loanedMonth <= 12) {
            newLoanedMonth = String.valueOf(loanedMonth);
        }
        if(this.loanedDay < 10 && this.loanedDay > 0){
            newLoanedDay = String.format("%02d", loanedDay);
        }
        if(this.loanedDay > 9 && this.loanedDay <= 31){
            newLoanedDay = String.valueOf(loanedDay);
        }

        if(this.returnedMonth < 10 && this.returnedMonth > 0){
            newReturnedMonth = String.format("%02d", returnedMonth);
        }
        if(this.returnedMonth > 9 && this.returnedMonth <=12){
            newReturnedMonth = String.valueOf(returnedMonth);
        }
        if(this.returnedDay < 10 && this.returnedDay > 0 ){
            newReturnedDay = String.format("%02d", returnedDay);
        }
        if(this.returnedDay > 9 && this.returnedDay <=31){
            newReturnedDay = String.valueOf(returnedDay);
        }

        String str = this.title +"\n"+ newLoanedMonth +"/"+ newLoanedDay + "/" + this.loanedYear;
        String sty = newReturnedMonth + "/" + newReturnedDay + "/" + this.returnedYear;

        return str + "\n" + sty + "\n" + "Penalty: " + String.format("%.2f", penalty());
    }
}
