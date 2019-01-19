package pl.pwn.reaktor.challenge.service;


import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pwn.reaktor.challenge.model.Firmy;
import pl.pwn.reaktor.challenge.repository.FirmyRepository;
import pl.pwn.reaktor.challenge.repository.OdpadyRepository;

import java.util.Date;


@Service
public class FirmyService {


    private FirmyRepository firmyRepository;

    @Autowired
    public FirmyService(FirmyRepository firmyRepository) {
        this.firmyRepository = firmyRepository;
    }

    public Firmy addFrima(Firmy firma) {
        Firmy saveFrima = firmyRepository.save(firma);
        return saveFrima;
    }


}
