package za.ac.cput.digitalpharmacysystem.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

//Author: 221066748 (Noxolo Portia Ngubo)

@Entity
@Table(name = "patient_profile")

public class PatientProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    private LocalDate dateOfBirth;
    private String allergies;
    private String chronicConditions;
    private String emergencyContactPhone;

    protected PatientProfile() {}

    private PatientProfile(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.dateOfBirth = builder.dateOfBirth;
        this.allergies = builder.allergies;
        this.chronicConditions = builder.chronicConditions;
        this.emergencyContactPhone = builder.emergencyContactPhone;
    }

    public Long getId() { return id; }
    public User getUser() { return user; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getAllergies() { return allergies; }
    public String getChronicConditions() { return chronicConditions; }
    public String getEmergencyContactPhone() { return emergencyContactPhone; }

    public static class Builder {
        private Long id;
        private User user;
        private LocalDate dateOfBirth;
        private String allergies;
        private String chronicConditions;
        private String emergencyContactPhone;

        public Builder setId(Long id) { this.id = id; return this; }
        public Builder setUser(User user) { this.user = user; return this; }
        public Builder setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; return this; }
        public Builder setAllergies(String allergies) { this.allergies = allergies; return this; }
        public Builder setChronicConditions(String chronicConditions) { this.chronicConditions = chronicConditions; return this; }
        public Builder setEmergencyContactPhone(String emergencyContactPhone) { this.emergencyContactPhone = emergencyContactPhone; return this; }

        public Builder copy(PatientProfile profile) {
            this.id = profile.id;
            this.user = profile.user;
            this.dateOfBirth = profile.dateOfBirth;
            this.allergies = profile.allergies;
            this.chronicConditions = profile.chronicConditions;
            this.emergencyContactPhone = profile.emergencyContactPhone;
            return this;
        }

        public PatientProfile build() { return new PatientProfile(this); }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientProfile profile = (PatientProfile) o;
        return Objects.equals(id, profile.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
