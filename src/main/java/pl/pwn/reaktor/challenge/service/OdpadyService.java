package pl.pwn.reaktor.challenge.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.pwn.reaktor.challenge.model.Odpady;
import pl.pwn.reaktor.challenge.repository.OdpadyRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class OdpadyService {

    private OdpadyRepository odpadyRepository;

    @Autowired
    public OdpadyService(OdpadyRepository odpadyRepository) {
        this.odpadyRepository = odpadyRepository;
    }

    //zapis do bazy danych przy użyciu odpadyRepository
    public Odpady dodajOdpady(Odpady odpady){
        odpady.setDataKpo(LocalDate.now());
        return odpadyRepository.save(odpady);
    }

    public Odpady getLastOdpady(){
        return odpadyRepository.findFirstByOrderByIdDesc();
    }

    public List<Odpady> getAllOdpady(){
        return odpadyRepository.findAll(Sort.by("kod_odpadu").descending());
    }

    public Odpady getById(long id){
        return odpadyRepository.getOne(id);
    }
}
