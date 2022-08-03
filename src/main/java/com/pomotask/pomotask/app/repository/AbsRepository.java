package com.pomotask.pomotask.app.repository;

import com.pomotask.pomotask.app.model.AbsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;


@NoRepositoryBean
public interface AbsRepository<Model extends AbsModel>
        extends JpaRepository<Model, Integer> {

    Optional<Model> findByUserIdAndId(Integer userId, Integer id);

}
