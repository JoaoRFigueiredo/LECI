package aula07.ex2;
import java.time.OffsetDateTime;


public class DateYMD extends Date{
    private int dia, mes, ano;
    

//construtor que com a data atual
public DateYMD(){
    OffsetDateTime data = OffsetDateTime.now();
    int dia = data.getDayOfMonth();
    int mes = data.getMonthValue();
    int ano = data.getYear();
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;

}
    
    public DateYMD(int dia, int mes, int ano){
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
        if (valid(newDay, newMonth, newYear))
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

@Override
public String toString(){
    return String.format("%d - %d - %d", this.ano, this.mes, this.dia);
}

@Override
public boolean equals(Object obj){
    if(this == obj){
        return true;
    }
    if(obj == null){
        return false;
    }
    if(getClass() != obj.getClass()){
        return false;
    }

    DateYMD other = (DateYMD)obj;
    if(ano != other.ano){
        return false;
    }
    if(mes != other.mes){
        return false;
    }
    if(dia != other.dia){
        return false;
    }

    return true;



}

@Override
public int hashCode(){
    final int prime = 31;
    int result = 1;
    result = prime * result + ano;
    result = prime *result + mes;
    result = prime * result + dia;
    return result;
}

public int compareTo(DateYMD date2) {
    if (this.getYear() < date2.getYear()) return -1;
    else if (this.getYear() > date2.getYear()) return 1;

    if (this.getMonth() < date2.getMonth()) return -1;
    else if (this.getMonth() > date2.getMonth()) return 1;

    if (this.getDay() < date2.getDay()) return -1;
    else if (this.getDay() > date2.getDay()) return 1;

    return 0;
}



}
