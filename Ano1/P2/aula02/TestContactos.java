import pt.ua.prog2.*;


public class TestContactos {
	
	public static void main (String[] args) {
		  contactos[] cl = new contactos[4];
    cl[0] = new contactos("Ana", "978676760");
    cl[1] = new contactos("Rita", "867367834", "rita@gmail.com");
    cl[2] = new contactos("Paulo", "897476388", "paulo@hotmail.com");
    cl[3] = new contactos("Carlos", "674767867" );
    for (int i = 0; i < cl.length; i++) {
      System.out.println(cl[i].nome() + 
          ": " + cl[i].telefone() + 
          "; " + cl[i].eMail());
    }
	}
}

