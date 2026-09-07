package za.ac.cput.digitalpharmacysystem.service;

import za.ac.cput.digitalpharmacysystem.domain.PatientProfile;
import java.util.List;

//Author: 221066748 (Noxolo Portia Ngubo)

public interface IPatientProfileService extends IService<PatientProfile, Long> {
    List<PatientProfile> getAll();
}
