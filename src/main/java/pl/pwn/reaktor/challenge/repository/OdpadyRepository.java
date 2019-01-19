package pl.pwn.reaktor.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pwn.reaktor.challenge.model.Odpady;

@Repository
public interface OdpadyRepository extends JpaRepository<Odpady, Long> {
}
