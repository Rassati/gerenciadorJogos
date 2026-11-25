package br.senac.tads.dsw.gerenciadordejogos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JogoRepository extends JpaRepository <JogoEntity, Integer> {
	Optional<JogoEntity> getJogoById(int id);
}
