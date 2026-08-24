package br.com.unipds.javify.administrativo.repository;

import br.com.unipds.javify.administrativo.domain.Usuario;
import br.com.unipds.javify.administrativo.repository.projection.ResumoUsuario;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query("select u from Usuario u where u.titular = true")
    List<Usuario> findByTitularTrue();

    @Query("select u from Usuario u WHERE LOWER(u.nome) LIKE LOWER(CONCAT('%', :termo, '%')) Order by u.nome")
    List<Usuario> buscarPorNome(String termo);

    @Query("select count(u) from Usuario u where u.titular = true")
    long contarTitularesAtivos();

    @Query("select new br.com.unipds.javify.administrativo.repository.projection.ResumoUsuario(u.nome, u.email) " +
            "from Usuario u where u.titular = true order by u.nome")
    List<ResumoUsuario> listaResumoTitulares();
}
