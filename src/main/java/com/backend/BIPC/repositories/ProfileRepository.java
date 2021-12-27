package com.backend.BIPC.repositories;

import com.backend.BIPC.entities.auth.User;
import com.backend.BIPC.entities.user.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
    public Profile findByUser(User user);
}
