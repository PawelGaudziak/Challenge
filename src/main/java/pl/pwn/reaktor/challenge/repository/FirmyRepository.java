package pl.pwn.reaktor.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pwn.reaktor.challenge.model.Firmy;

@Repository
public interface FirmyRepository extends JpaRepository<Firmy, Long> {

    Firmy findOneByEmail(String email);

}
