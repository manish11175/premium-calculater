package com.backend.BIPC.repositories;

import com.backend.BIPC.entities.quote.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface PropertyDetailsRepository extends JpaRepository<PropertyDetails,Long> {
}
