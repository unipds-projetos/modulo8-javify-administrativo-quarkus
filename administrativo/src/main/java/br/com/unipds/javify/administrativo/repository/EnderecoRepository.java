package br.com.unipds.javify.administrativo.repository;

import br.com.unipds.javify.administrativo.domain.Endereco;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Find;
import jakarta.data.repository.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

    @Find
    Optional<Endereco> findByCodigoPostal(String codigoPostal);
}
