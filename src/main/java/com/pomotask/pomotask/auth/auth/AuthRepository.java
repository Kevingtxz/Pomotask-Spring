package com.pomotask.pomotask.auth.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<AuthModel, Integer> {


    @Transactional(readOnly = true)
    Optional<AuthModel> findByEmail(String email);

    @Modifying
    void deleteByEmail(String email);

}
