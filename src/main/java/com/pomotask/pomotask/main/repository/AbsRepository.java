package com.pomotask.pomotask.main.repository;

import com.pomotask.pomotask.main.domain.AbsModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@NoRepositoryBean
public interface AbsRepository<Model extends AbsModel>
        extends JpaRepository<Model, Integer> {


    @Transactional
    Set<Model> findAllByUserAuthEmail(String userEmail);

    @Transactional(readOnly = true)
    Page<Model> findPageByUserAuthEmail(
            String userEmail, PageRequest pageRequest);

    Optional<Model> findByUserAuthEmailAndId(String userEmail, Integer id);

    @Modifying
    void deleteByUserAuthEmailAndId(String userEmail, Integer id);

}
