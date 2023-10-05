package aula05;

public class Date {
    private int dia, mes, ano;
    

//construtor que ccria uma data aleatória
    public Date(){
        this.ano = 1001;
        this.mes = 1;
        this.dia = 1;
        
        
    }
    public Date(int dia, int mes, int ano){
        if(!valid(dia, mes, ano)){ throw new IllegalArgumentException();}
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    //getters and setters

    public int getDay(){
        return dia;
    }

    public int getMonth(){
        return mes;
    }

    public int getYear(){
        return ano;
    }

    public void set(int newDay, int newMonth, int newYear){
        this.dia = newDay;
        this.mes = newMonth;
        this.ano = newYear;
    }

    public void setDay(int newDay){
        this.dia = newDay;
    }

    public void setMonth(int newMonth){
        this.mes = newMonth;
    }

    public void setYear(int newYear){
        this.ano = newYear;
    }

    public static boolean isLeapYear(int year){
        return ((year % 4 == 0 && year %100 != 0) || (year % 400 == 0));
    }

    public static boolean validMonth(int month){
        return month >0 && month < 13;
    }

    public static int monthDays(int month, int year){
        int dias;
        switch(month){
            case 4:
            case 6:
            case 9:
            case 11:
                dias = 30;
                break;
            case 2:
                if( isLeapYear(year)){
                    dias = 29;
    
                }
                else{
                    dias = 28;
                }
                break;
            default:
                dias = 31;
                break;
        }
        return dias;

    }

    public  boolean valid(){
        boolean valid = false;
        if(this.ano >= 0){
            if(validMonth(this.mes)){
                if(isLeapYear(this.ano)){
                    if(this.dia > 0 && this.dia < monthDays(this.mes, this.ano)){
                    valid = true;
                    
                    }
            }
        }
    }
    return valid;
}

    public static boolean valid(int dia, int mes, int ano){
        boolean valid = false;
        if(ano >= 0){
            if(validMonth(mes)){
                    if(dia > 0 && dia < monthDays(mes, ano)){
                    valid = true;
            }
        }
    }
    return valid;
}

public void increment(){
    //dia++
    this.dia++;
    if(this.dia > monthDays(this.mes, this.ano)){
        this.dia =1;
        //mes++
        this.mes++;
        if(this.mes > 12 ){
            this.mes = 1;
            this.ano++;
        }
    }
}

public void decrement(){
    //dia--
    this.dia--;
    if(this.dia < 1){
        this.mes--;
        //ano altera
        if(this.mes < 1){
            this.ano--;
            this.mes = 12;
            this.dia = monthDays(this.mes, this.ano);
        }
        //ano não altera
        else{
            this.dia = monthDays(this.mes, this.ano);
        }
    }
}

public String toString(){
    return String.format("%d - %d - %d", this.ano, this.mes, this.dia);
}

}
