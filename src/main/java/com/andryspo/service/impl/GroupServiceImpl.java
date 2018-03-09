package com.andryspo.service.impl;

import com.andryspo.domain.dto.group.GroupDataDto;
import com.andryspo.domain.dto.group.GroupResponseDto;
import com.andryspo.domain.entity.WordGroup;
import com.andryspo.domain.entity.User;
import com.andryspo.mapper.GroupMapper;
import com.andryspo.repository.GroupRepo;
import com.andryspo.service.GroupService;
import com.andryspo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public void addGroup(GroupDataDto groupDataDto) {
        LOGGER.info("add wordGroup");

        User user = userService.getUserFromSession();
        WordGroup wordGroup = groupMapper.mapToEntity(groupDataDto);
        wordGroup.setUser(user);
        groupRepo.save(wordGroup);
    }

    @Override
    public List<GroupResponseDto> getGroups() {
        LOGGER.info("get all uswe groups");

        List<WordGroup> wordGroup = groupRepo.findAllByUser(userService.getUserFromSession());
        return wordGroup.stream().map(e -> new GroupResponseDto(e.getId(), e.getTitle())).collect(Collectors.toList());
    }
}
