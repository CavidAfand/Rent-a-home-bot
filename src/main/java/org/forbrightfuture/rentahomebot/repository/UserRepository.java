package org.forbrightfuture.rentahomebot.repository;

import org.forbrightfuture.rentahomebot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserById(Long id);

}
