package aula08.Ex1;

public class Ex1 {
    
    public static void main(String[] args){

        EmpresaAluguer empresa = new EmpresaAluguer("Empresa", "1234-567", "Empresa@ua.pt");

        Motociclo m1 = new Motociclo("bc-12-12", "bmw", "x", 120, "estrada");
        m1.trajeto(50);
        Motociclo m2 = new Motociclo("bc-12-13", "bmw", "x", 120, "estrada");
        m2.trajeto(25);
        Motociclo m3 = new Motociclo("bc-12-14", "bmw", "x", 120, "estrada");
        m3.trajeto(75);

        AutomovelLigeiro aut1 = new AutomovelLigeiro("abs", "mercedes", "smth", 160, 67, 600);
        aut1.trajeto(10);
        AutomovelLigeiro aut2 = new AutomovelLigeiro("abo", "mercedes", "smth", 160, 67, 600);
        aut2.trajeto(20);

        PesadoMercadorias p1 = new PesadoMercadorias("ola", "fiat", "olx", 59, 45, 1500, 680);
        p1.trajeto(90);
        PesadoMercadorias p2 = new PesadoMercadorias("ol2", "fiat", "olx", 59, 45, 1500, 680);
        p2.trajeto(80);
        
        empresa.addVeiculos(m1, m2, m3);
        empresa.addVeiculos(p1, p2);
        empresa.addVeiculos(aut1, aut2);

        System.out.println(empresa);

        for ( Veiculo veiculo : empresa.getVeiculos() ) {
            System.out.println(veiculo);
        }

        Veiculo veiculoMaiorDist = null;

        for( Veiculo v : empresa.getVeiculos() ){
            if (veiculoMaiorDist == null) veiculoMaiorDist = v;

            if(v.distanciaTotal() > veiculoMaiorDist.distanciaTotal()) veiculoMaiorDist = v;
        }
    

    System.out.println(veiculoMaiorDist);

}


}