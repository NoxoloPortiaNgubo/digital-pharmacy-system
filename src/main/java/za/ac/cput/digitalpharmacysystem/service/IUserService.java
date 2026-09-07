package za.ac.cput.digitalpharmacysystem.service;

import za.ac.cput.digitalpharmacysystem.domain.User;
import java.util.List;

public interface IUserService extends IService<User, Long> {
    List<User> getAll();
}
