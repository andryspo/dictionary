package com.andryspo.service.impl;

import com.andryspo.domain.dto.word.WordDataDto;
import com.andryspo.domain.entity.WordGroup;
import com.andryspo.domain.entity.User;
import com.andryspo.domain.entity.Word;
import com.andryspo.mapper.WordMapper;
import com.andryspo.repository.GroupRepo;
import com.andryspo.repository.WordRepo;
import com.andryspo.service.UserService;
import com.andryspo.service.WordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordService.class);

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private WordRepo wordRepo;

    @Autowired
    private WordMapper wordMapper;

    @Autowired
    private UserService userService;

    @Override
    public void addToGroup(Long groupId, WordDataDto wordDataDto) {
        LOGGER.info("add word to wordGroup");

        WordGroup wordGroup = groupRepo.findOne(groupId);
        Word word = wordMapper.mapToEntity(wordDataDto);
        word.setWordGroup(wordGroup);
        wordRepo.save(word);
    }

    @Override
    public List<Word> getAllFromGroup(Long groupId) {
        return groupRepo.findOne(groupId).getWords();
    }

    @Override
    public List<Word> getAll() {
        User user = userService.getUserFromSession();
        return wordRepo.findAllWordsByUser(user);
    }

    @Override
    public void delete(long id) {
        LOGGER.warn("deleting word: {}", id);
        wordRepo.delete(id);
    }
}
