package za.ac.cput.digitalpharmacysystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.digitalpharmacysystem.domain.PatientProfile;
import za.ac.cput.digitalpharmacysystem.service.IPatientProfileService;

import java.util.List;

//Author: 221066748 (Noxolo Portia Ngubo)

@RestController
@RequestMapping("/patientprofile")
public class PatientProfileController {

    private final IPatientProfileService profileService;

    @Autowired
    public PatientProfileController(IPatientProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/create")
    public ResponseEntity<PatientProfile> create(@RequestBody PatientProfile profile) {
        PatientProfile created = profileService.create(profile);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<PatientProfile> read(@PathVariable Long id) {
        PatientProfile profile = profileService.read(id);
        if (profile == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profile);
    }

    @PostMapping("/update")
    public ResponseEntity<PatientProfile> update(@RequestBody PatientProfile profile) {
        PatientProfile updated = profileService.update(profile);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = profileService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PatientProfile>> getAll() {
        return ResponseEntity.ok(profileService.getAll());
    }
}
