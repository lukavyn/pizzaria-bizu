package br.com.pizzariabizu.backend.repository;

import br.com.pizzariabizu.backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByEmail(String email);
}
