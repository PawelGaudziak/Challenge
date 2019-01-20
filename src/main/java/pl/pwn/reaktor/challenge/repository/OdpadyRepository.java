package pl.pwn.reaktor.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.pwn.reaktor.challenge.model.Odpady;

import java.util.List;

@Repository
public interface OdpadyRepository extends JpaRepository<Odpady, Long> {

    Odpady findFirstByOrderByIdDesc();

    @Query(nativeQuery=true, value = "SELECT SUM(masa) FROM odpady")
    double sumujOdpady();
}
