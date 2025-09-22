package com.borisdvlpr.sample.service.impl;

import com.borisdvlpr.sample.domain.entities.Tag;
import com.borisdvlpr.sample.repository.TagRepository;
import com.borisdvlpr.sample.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    @Override
    public List<Tag> getTags() {
        return tagRepository.findAllWithPostCount();
    }
}
