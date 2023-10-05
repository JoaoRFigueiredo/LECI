package aula07.ex2;

public class DateND extends Date{
    private int days;

    public DateND(int day, int month, int year){
        set(day, month, year);
    }

    public DateYMD convert(){
        DateYMD dateYMD = new DateYMD(1, 1, 2000);

        if (days < 0) dateYMD.decrement(days);
        else if (days > 0) dateYMD.increment(days);

        return dateYMD;
    }
    


    public void set(int day, int month, int year){
        DateYMD base = new DateYMD(1, 1, 2000);

        DateYMD target = new DateYMD(day, month, year);

        this.days = 0;
        if(target == base){
            this.days = 0;
        }

        else if(target.compareTo(base) < 0){
            while(target.compareTo(base) < 0){
                this.days--;
                base.decrement();
            }
        }
        else{
            while(target.compareTo(base) > 0){
                this.days++;
                base.increment();;
            }
        }
    }

    @Override
    public int getMonth() {
        return this.convert().getMonth();
    }

    @Override
    public int getDay() {
        return this.convert().getDay();
    }

    @Override
    public int getYear() {
        return this.convert().getYear();
    }

    @Override
    public void increment() {
        days++;
        
    }

    @Override
    public void decrement() {
        days--;
        
    }

}
