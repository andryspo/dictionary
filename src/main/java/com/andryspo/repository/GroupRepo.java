package com.andryspo.repository;

import com.andryspo.domain.entity.WordGroup;
import com.andryspo.domain.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepo extends CrudRepository<WordGroup, Long> {

    List<WordGroup> findAllByUser(User user);

}
