package br.com.unipds.javify.administrativo;

import br.com.unipds.javify.administrativo.demonstracao.AcessoJDBC;
import br.com.unipds.javify.administrativo.demonstracao.DemoJpa;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class AdministrativoApplication implements QuarkusApplication {

    private final AcessoJDBC acessoJdbc;
    private final DemoJpa demoJpa;

    public AdministrativoApplication(AcessoJDBC acessoJdbc, DemoJpa demoJpa) {
        this.acessoJdbc = acessoJdbc;
        this.demoJpa = demoJpa;
    }

    public static void main(String[] args) {
		Quarkus.run(AdministrativoApplication.class, args);
	}

    @Override
    public int run(String... args) throws Exception {
        //acessoJdbc.executar();
        //demoJpa.buscaEndereco();
        //demoJpa.cadastraEndereco();
        //demoJpa.atualizaEndereco();
        //demoJpa.buscarAssinaturaComPlano();
        //demoJpa.removerCartaoVencido();
        demoJpa.testarConsultas();
        return 0;
    }


}
