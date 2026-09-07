package za.ac.cput.digitalpharmacysystem.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Objects;

//Author: 221066748 (Noxolo Portia Ngubo)

@Entity
@Table(name = "system_user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    public enum UserRole {
        CUSTOMER, PHARMACIST, COURIER, ADMIN
    }

    protected User() {}

    private User(Builder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.passwordHash = builder.passwordHash;
        this.phone = builder.phone;
        this.role = builder.role;
    }

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public String getPhone() { return phone; }
    public UserRole getRole() { return role; }

    public static class Builder {
        private Long id;
        private String fullName;
        private String email;
        private String passwordHash;
        private String phone;
        private UserRole role;

        public Builder setId(Long id) { this.id = id; return this; }
        public Builder setFullName(String fullName) { this.fullName = fullName; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public Builder setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; return this; }
        public Builder setPhone(String phone) { this.phone = phone; return this; }
        public Builder setRole(UserRole role) { this.role = role; return this; }

        public Builder copy(User user) {
            this.id = user.id;
            this.fullName = user.fullName;
            this.email = user.email;
            this.passwordHash = user.passwordHash;
            this.phone = user.phone;
            this.role = user.role;
            return this;
        }

        public User build() { return new User(this); }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() { return Objects.hash(id, email); }
}
