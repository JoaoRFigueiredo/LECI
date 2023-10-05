package aula09.Ex1;

 import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;





public class ALDemo {
    public static void main(String[] args) {
        ArrayList<Integer> c1 = new ArrayList<>();
        for (int i = 10; i <= 100; i+=10)
        c1.add(i);
        System.out.println("Size: " + c1.size());
        for (int i = 0; i < c1.size(); i++)
        System.out.println("Elemento: " + c1.get(i));
        ArrayList<String> c2 = new ArrayList<>();
        c2.add("Vento");
        c2.add("Calor");
        c2.add("Frio");
        c2.add("Chuva");
        System.out.println(c2);
        Collections.sort(c2);
        System.out.println(c2);
        c2.remove("Frio");
        c2.remove(0);
        System.out.println(c2);
        List<String> d  = c2.subList(1, 2);
        System.out.println(d);

        System.out.println("-----------------------b)--------------------");

        Set<Pessoa> c3 = new HashSet<>();
        c3.add(new Pessoa("Jose Alves", 1234567, new Date(12, 2, 2001)));
        c3.add(new Pessoa("Ana Paiva", 12467897, new Date(16, 2, 1995)));
        c3.add(new Pessoa("Joao Pedro", 134534567, new Date(19, 9, 1997)));
        c3.add(new Pessoa("Maria Albertina", 1124567, new Date(29, 10, 2001)));
        c3.add(new Pessoa("Antonio Costa", 9999999, new Date(21, 5, 1998)));

        Iterator<Pessoa> it = c3.iterator();
        while(it.hasNext()){System.out.println(it.next());}
        //testar adição de pessoa existente
        System.out.println(c3.add(new Pessoa("Antonio Costa", 9999999, new Date(21, 5, 1998)))); //false

        //alinea c

        Set<Date> c4 = new TreeSet<>();
        c4.add(new Date(1, 2, 2000));
        c4.add(new Date(1, 2, 2001));
        c4.add(new Date(1, 2, 2002));
        c4.add(new Date(1, 2, 2003));
        c4.add(new Date(1, 2, 2004));
        Iterator<Date> it1 = c4.iterator();
        while(it1.hasNext()){System.out.println(it1.next());}

    }
} 
    

