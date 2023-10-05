package aula05;

public class Callendar {
    private int weekday, ano;
    static String[] dias = {"Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};
    static String[] months = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

    public Callendar(int weekday, int ano){
        if(weekday < 1 || weekday > 7) throw new IllegalArgumentException();
        this.weekday = weekday;
        this.ano = ano;
    }

    //getters and setters
    public int getWeekDay(){
        return weekday;
    }

    public int getYear(){
        return ano;
    }

    public void setWeekDay(int newWeekDay){
        this.weekday = newWeekDay;
    }

    public void setYear(int newYear){
        this.ano = newYear;
    }

    public String firstweekDayOfYear(){
        return dias[this.weekday-1];
    }

    //array com o primeiro dia semanal de cada mês
    public int[] firstWeekdayOfMonth(){
        int[] firstWeekdayOfMonth = new int[12];
        firstWeekdayOfMonth[0] = this.weekday;
        int num = this.weekday;
       for(int i = 1; i<12; i++){
        num = num + Date.monthDays(i, this.ano);
        firstWeekdayOfMonth[i] = num%7;
       }

       return firstWeekdayOfMonth;

    }

    public String firstWeekdayOfMonth(int mes){
       int[] arr = firstWeekdayOfMonth();
       for(int i = 0; i<arr.length; i++){
           System.out.printf("\nMes %d, começa no dia %d",i+1, arr[i] );
       }
       return dias[arr[mes-1]-1];
    }

    public void displayCallendarMonth(int mes){
        System.out.println("\t\t\t"+months[mes-1]+" "+ano);
        System.out.println("Su\tMo\tTu\tWe\tTh\tFr\tSa");
        int d = 1;
        int[] arr = firstWeekdayOfMonth();
       
        for (int l = 0; l<6; l++){//percorrer as linhas do calendário
            System.out.println();
            
            for (int c = 0; c<7; c++){//percorrer as colunas do calendário
            
                if((l == 0 && c < arr[mes-1]-1) || (l>0 && d >Date.monthDays(mes, this.ano) )){
                    System.out.printf("%s\t", " ");
                }
                else{
                    System.out.printf("%d\t", d);
                    d++;
                }

                 
                 
        }
        
        
        
        }
    }
}


