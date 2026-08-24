package br.com.unipds.javify.administrativo.repository;

import br.com.unipds.javify.administrativo.domain.Assinatura;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssinaturaRepository extends CrudRepository<Assinatura, Integer> {

    @Query("select a from Assinatura a " +
            "join fetch a.plano")
    List<Assinatura> buscarAssinaturasComPlano();

    // Repositorio Jakarta Data e apoiado por StatelessSession: nao ha lazy loading
    // depois da consulta, entao a colecao de cartoes vem por join fetch.
    @Query("select a from Assinatura a " +
            "left join fetch a.cartoes " +
            "where a.id = :id")
    Optional<Assinatura> buscarComCartoes(Integer id);
}
