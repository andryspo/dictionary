package com.andryspo.repository;

import com.andryspo.domain.entity.WordGroup;
import com.andryspo.domain.entity.User;
import com.andryspo.domain.entity.Word;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepo extends CrudRepository<Word, Long> {

    List<Word> findAllByWordGroup(WordGroup wordGroup);

    @Query("select w from Word w where w.wordGroup.user=?1")
    List<Word> findAllWordsByUser(User user);

}
