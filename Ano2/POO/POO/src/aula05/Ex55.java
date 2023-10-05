package aula05;
import java.util.Scanner;
public class Ex55 {
   static Scanner sc = new Scanner(System.in);


    public static void main(String[] args){
       
        Livro catalogo[] = new Livro[100]; 
        Utilizador lista[] = new Utilizador[100];
        int option;
        do{
            System.out.println("1 - Increver Utilizador;"+
                             "\n2 - Remover Utilizador;"+
                             "\n3 - Imprimir lista de Utilizadores"+
                             "\n4 - Registar um novo livro"+
                             "\n5 - Imprimir lista de livros"+
                             "\n6 - Emprestar"+
                             "\n7 - Devolver"+
                             "\n8 - Sair");

            option = sc.nextInt();

            switch(option){
                case 1:
                    registar(lista);

                break;

                case 2:
                    removerUtilizador(lista);

                break;

                case 3:
                imprimirUtilizadores(lista);

                break;

                case 4:
                registarLivro(catalogo);

                break;

                case 5:
                imprimirLivros(catalogo);

                break;

                case 6:
                
                emprestar(catalogo, lista);

                break;

                case 7:
                devolver(catalogo, lista);

                break;

               default:
               break;

                
            }

        }while(option != 8);
      

    }

    public static void registar(Utilizador[] lista){
        sc.nextLine();
        System.out.println("Nome do aluno: ");
        String nome = sc.nextLine();
        System.out.println("Número mecanográfico do aluno: ");
        int nmec = sc.nextInt();
        System.out.println("Curso do aluno: ");
        sc.nextLine();
        String curso = sc.nextLine();
        Utilizador aluno = new Utilizador(nome, nmec, curso);
        for (int i = 0; i<lista.length; i++){
            if(lista[i] == null){
                lista[i] = aluno;
                System.out.println("O aluno foi registado com sucesso!");
                break;
            }
        }


    }

    public static void removerUtilizador(Utilizador[] lista){
        boolean check = false;
        sc.nextLine();
        System.out.println("Qual o nmec do aluno que deseja remover?");
        int nmec = sc.nextInt();
        for (int i = 0; i<lista.length; i++){
            if(lista[i] != null){
                if(lista[i].getNmec() == nmec){
                    System.out.println(lista[i].getNome()+" foi removido com sucesso");
                    lista[i] = null;
                    check = true;
                    break;
                }
            }
        }
        if(check == false){
            System.out.println("O utilizador com o nmec "+nmec+" não se encontra registado na nossa base de dados!");
        }
    }

    public static void imprimirUtilizadores(Utilizador[] lista){
        for (int i = 0; i<lista.length; i++){
            if(lista[i] != null){
                System.out.println(lista[i]);
            }
        }
    }


    public static void registarLivro(Livro[] lista){
        sc.nextLine();
        System.out.println("Qual o título do livro?");
        String titulo = sc.nextLine();
        String regime;
        System.out.println("Qual o regime de empréstimo do livro? (Normal ou condicional)");
        do{
            regime = sc.nextLine();
            regime = regime.toLowerCase();
        }while(!regime.equals("normal") && !regime.equals("condicional"));

        Livro l1 = new Livro(titulo, regime);
        for (int i = 0; i<lista.length; i++){
            if(lista[i] == null){
                lista[i] = l1;
                System.out.println("O livro foi registado com sucesso!");
                break;
            }
        }
    }

    public static void imprimirLivros(Livro[] lista){
        System.out.println("Lista de livros atual: ");
        for (int i = 0; i<lista.length; i++){
            if(lista[i] != null){
                System.out.println(lista[i]);
            }
        }
    }

    public static boolean emprestar(Livro[] lista, Utilizador[] alunos){
        sc.nextLine();
        boolean exist = false;
        Utilizador student = null;
        System.out.println("Insira o seu número mecanográfico: ");
        int nmec  = sc.nextInt();
        for (int i = 0; i<alunos.length; i++){
            if(alunos[i] != null){
                if(alunos[i].getNmec() == nmec){
                student = alunos[i];
                exist = true;
                break;
                //aluno existe
                }
            }
            }
        

        if(exist == false){
            System.out.println("O aluno não está registado nos nossos sistemas!");
            return false;
        }
        System.out.println("Insira o id do livro que deseja requesitar: ");
        sc.nextLine();
        int bookid = sc.nextInt();
        //encontrar o livro e ver se pode ser requisitado
        boolean check = false;
        for (int i = 0; i<lista.length; i++){
            if(lista[i].getId() == bookid){
                String reg = lista[i].getRegime();
                reg = reg.toLowerCase();
                String disp = lista[i].getDisp();
                disp = disp.toLowerCase();
                if(reg.equals("normal") && disp.equals("disponível")){;
                    if(student.adicionarLivro(bookid)){
                    lista[i].setDisp("Indisponível");
                    System.out.println("O livro foi requisitado com sucesso!");
                    break;
                    }
                    else{
                        System.out.println("Já excedeu a sua quota de livros emprestados(3)!");
                    }
                }
                else{
                    System.out.println("O livro não pode ser requisitado!");
                    break;
                }
            }
        }
        

        return check;


    }


    public static boolean devolver(Livro[] lista, Utilizador[] alunos){
        sc.nextLine();
        boolean exist = false;
        Utilizador student = null;
        System.out.println("Insira o seu número mecanográfico: ");
        int nmec  = sc.nextInt();
        for (int i = 0; i<alunos.length; i++){
            if(alunos[i] != null){
                if(alunos[i].getNmec() == nmec){
                student = alunos[i];
                exist = true;
                break;
                //aluno existe
                }
            }
            }
            if(exist == false){
                System.out.println("O aluno não está registado nos nossos sistemas!");
                return false;
            }
        System.out.println("Insira o id do livro que deseja devolver: ");
        int bookid = sc.nextInt();
        
        boolean check = false;
        for (int i = 0; i<lista.length; i++){
            
                check = student.removerLivro(bookid);
                if(check == true){
                    
                        if (lista[i].getId() == bookid){
                            lista[i].setDisp("Disponível");
                            System.out.println("Devolvido com sucesso!");
                            break;
                        }
                    
                
            }
            else{
                System.out.println("Houve um problema na devolução do livro!");
            }
        }
       

         return check;
    }


    
  
}
