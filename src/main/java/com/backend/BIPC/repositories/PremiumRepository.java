package com.backend.BIPC.repositories;

import com.backend.BIPC.entities.quote.Premium;
import com.backend.BIPC.entities.quote.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PremiumRepository extends JpaRepository<Premium,Long> {

    Premium findByProperty(Property property);
}

