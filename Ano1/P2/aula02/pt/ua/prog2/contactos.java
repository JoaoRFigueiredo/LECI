package pt.ua.prog2 ;


public class contactos {
	
	  
  public contactos(String nome, String telefone, String eMail){
	  this.nome = nome;
	  this.telefone = telefone;
	  this.eMail = eMail;
	  }
	  
	  public contactos(String nome, String telefone){
		  this.nome = nome;
		  this.telefone = telefone;
	  }
	  
	  public String nome(){
		  nome = nome.toUpperCase();
		  return nome;}
		
      public String telefone(){
	      return telefone;
	  }
	  
	  public String eMail(){
		  return eMail;
	  }
	  		  
	  private String nome;
      private String telefone;
      private String eMail;
}

