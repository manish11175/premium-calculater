package com.backend.BIPC.repositories;

import com.backend.BIPC.entities.auth.User;
import com.backend.BIPC.entities.quote.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PropertyRepository extends JpaRepository<Property,Long> {
    Property findByUser(User user);
//    Property findById(Long id);
}
