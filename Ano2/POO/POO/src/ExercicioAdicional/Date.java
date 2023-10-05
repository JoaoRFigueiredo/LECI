package ExercicioAdicional;

public abstract class Date {

    public abstract int getMonth();
    public abstract int getDay();
    public abstract int getYear();
    public abstract void set(int day, int month, int year);
    public abstract void increment();
    public abstract void decrement();


    public static boolean isLeapYear(int year){
        return ((year % 4 == 0 && year %100 != 0) || (year % 400 == 0));
    }

    public static boolean validMonth(int month){
        return month >0 && month < 13;
    }

    public static int monthDays(int month, int year){
        if (month == 2){
            if (isLeapYear(year)){
                return 29;
            }
            else{
                return 28;
            }
        }
        else if(month == 4 || month == 6 || month == 9 || month == 11){
            return 30;
        }

        else{
            return 31;
        }
    }

    public static boolean valid(int day, int month, int year){
        return validMonth(month) && day > 0 && day <= monthDays(month, year);
    }


	public void increment(int days) {
		for (int i = 0; i < days; i++)
			increment();
	}

    public void decrement(int days) {
		for (int i = 0; i < days; i++)
			decrement();
	}

	@Override
	public String toString() {
		return String.format("%04d-%02d-%02d", this.getYear(), this.getMonth(), this.getDay());
	}
    
}
