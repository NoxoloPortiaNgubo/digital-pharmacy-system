package za.ac.cput.digitalpharmacysystem.service;

import za.ac.cput.digitalpharmacysystem.domain.PatientProfile;
import java.util.List;

public interface IPatientProfileService extends IService<PatientProfile, Long> {
    List<PatientProfile> getAll();
}
