import static java.lang.System.*;
import java.util.Calendar;


public class Data {
  private int dia, mes, ano;
  

  /** Inicia esta data com o dia de hoje. */
  public Data() {
    // Aqui usamos a classe Calendar da biblioteca standard para obter a data atual.
    Calendar today = Calendar.getInstance();
    dia = today.get(Calendar.DAY_OF_MONTH);
    mes = today.get(Calendar.MONTH) + 1;
    ano = today.get(Calendar.YEAR);
  }

  /** Inicia a data a partir do dia, mes e ano dados. */
  public Data(int dia, int mes, int ano) {
    //...
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }
  public Data(String s){
    String[] d = s.split("-");
    if (d.length != 3)System.exit(1);
    this.ano = Integer.parseInt(d[0]);
    this.mes = Integer.parseInt(d[1]);
    this.dia = Integer.parseInt(d[2]);
  }

  
 

  /** Indica se ano é bissexto. */
  public static boolean bissexto(int ano) {
    return ano%4 == 0 && ano%100 != 0 || ano%400 == 0;
  }
  /** Devolve esta data segundo a norma ISO 8601. */
  public String toString() {
    return String.format("%04d-%02d-%02d", ano, mes, dia);
  }

  // Crie métodos para obter o dia, mes e ano da data.
   public int mes(){
	   return mes;}
	   
	   public int ano(){
	   return ano;}
	   
	   public int dia(){
	   return dia;}
  //...

  /** Dimensões dos meses num ano comum. */
  private static final
  int[] diasMesComum = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  /** Devolve o número de dias do mês dado. */
  public static int diasDoMes(int mes, int ano) {
    //...
     if (mes == 1 ) return 31;
     if(mes == 2){if (bissexto(ano)) return 29;
    }else return 28;
    if(mes ==3) return 31;
    if(mes ==4) return 30;
    if(mes ==5) return 31;
    if(mes ==6) return 30;
    if(mes ==7) return 31;
    if(mes ==8) return 31;
    if(mes ==9) return 30;
    if(mes ==10) return 31;
    if(mes == 11) return 30;
    else return 31;
    
    
     

	
    
    
    
        
    
  }

  /** Devolve o mes da data por extenso. */
  public String mesExtenso() {
    //...
    if (mes == 1) return "janeiro";
    else if (mes ==2 ) return "fevereiro";
    else if (mes ==3 ) return "marco";
    else if (mes ==4 ) return "abril";
    else if (mes ==5 ) return "maio";
    else if (mes ==6 ) return "junho";
    else if (mes ==7 ) return "julho";
    else if (mes ==8 ) return "agosto";
    else if (mes ==9 ) return "setembro";
    else if (mes ==10 ) return "outubro";
    else if (mes ==11 ) return "novembro";
    else if (mes ==12 ) return "dezembro";
    else return "mes invalido";
  }


  /** Devolve esta data por extenso. */
  public String extenso() {
    return dia+" de "+mesExtenso()+" de "+ano;
  }

  /** Indica se um terno (dia, mes, ano) forma uma data válida. */
  public static boolean dataValida(int dia, int mes, int ano) {
    if ( ano > 0){
		if(mes > 0 && mes < 13){
			if(dia <= diasDoMes(ano, mes) && dia > 0) return true;
			else return false;
		}else return false;
	}
	else return false;
    
  }


  public void seguinte() {
    //...
    dia++;
		if(dia > diasDoMes(ano,mes)){
			mes++;
			dia = 1;
			if(mes > 12){
				mes = 1;
				ano++;
			}
		}
	
  }
  public int compareTo(Data data2)
	{
		int dia2=data2.dia();
		int mes2=data2.mes();
		int ano2=data2.ano();
		int res;
		if ((dia2==dia) && (mes2==mes) && (ano2==ano))
			res=0;   //datas são iguais -- res=0
		else if ((ano2>ano)|| ((ano2==ano) && (mes2>mes)) ||( (ano2==ano) && (mes2==mes) && (dia2>dia)))
			res=-1;  //data2>data1
		else 
			res=1;   //data1>data2
		return res;	
	}


}

