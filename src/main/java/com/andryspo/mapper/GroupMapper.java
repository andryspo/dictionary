package com.andryspo.mapper;

import com.andryspo.domain.dto.group.GroupDataDto;
import com.andryspo.domain.entity.WordGroup;
import org.springframework.stereotype.Service;

@Service
public final class GroupMapper implements Mapper<WordGroup, GroupDataDto> {

    @Override
    public WordGroup mapToEntity(GroupDataDto groupDataDto) {
        return new WordGroup(groupDataDto.getTitle());
    }

    @Override
    public GroupDataDto mapToDto(WordGroup wordGroup) {
        return new GroupDataDto(wordGroup.getTitle());
    }
}
