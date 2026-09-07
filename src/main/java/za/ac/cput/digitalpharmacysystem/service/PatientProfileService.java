package za.ac.cput.digitalpharmacysystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.digitalpharmacysystem.domain.PatientProfile;
import za.ac.cput.digitalpharmacysystem.repository.PatientProfileRepository;

import java.util.List;

@Service
public class PatientProfileService implements IPatientProfileService {

    private final PatientProfileRepository repository;

    @Autowired
    public PatientProfileService(PatientProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public PatientProfile create(PatientProfile profile) {
        return repository.save(profile);
    }

    @Override
    public PatientProfile read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public PatientProfile update(PatientProfile profile) {
        if (repository.existsById(profile.getId())) {
            return repository.save(profile);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<PatientProfile> getAll() {
        return repository.findAll();
    }
}