package com.andryspo.service;

import com.andryspo.domain.dto.group.GroupDto;
import com.andryspo.domain.dto.word.WordDataDto;
import com.andryspo.domain.dto.word.WordDto;
import com.andryspo.domain.entity.Word;

import java.util.List;

public interface WordService {

    void addToGroup(Long groupId, WordDataDto wordDataDto);

    List<Word> getAllFromGroup(Long groupId);

    List<Word> getAll();

    void delete(long id);

}
