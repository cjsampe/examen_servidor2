package com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories;


import com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories.dto.StoryInDto;
import com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories.dto.StoryOutDto;
import com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories.exception.StoryInvalidPatchParameterException;
import com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories.exception.StoryNotFoundException;
import com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories.model.Story;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StoryServiceImpl implements StoryService {
    @Autowired
    private StoryRepository storyRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StoryOutDto> get(){
        List<Story> stories = storyRepository.findAll();
        return getStoryOutDtos(stories);

    }

    @Override
    public StoryOutDto get(long id){
        return getStoryOutDto(getStoryOrFail(id));
    }

    @Override
    public List<Story> findByCategory(String category) {
        List<Story> stories = storyRepository.findByCategory(category);
        return stories;
    }
    @Override
    public StoryOutDto post(@RequestBody StoryInDto bookInDto) {
        Story newStory = new Story();
        modelMapper.map(bookInDto, newStory);
        storyRepository.save(newStory);
        return getStoryOutDto(newStory);
    }

    @Override
    public StoryOutDto put(long id, StoryInDto storyInDto) {
        Story story = getStoryOrFail(id);
        modelMapper.map(storyInDto, story);
        storyRepository.save(story);
        return getStoryOutDto(story);
    }

    @Override
    public StoryOutDto patch(long id, Map<String, Object> patchParameters) {
        Story story = getStoryOrFail(id);
        patchParameters.forEach((key, value) -> {
            switch (key) {
                case "title":
                    story.setTitle(String.valueOf(value));
                    break;
                case "description":
                    story.setDescription(String.valueOf(value));
                    break;
                case "text":
                    story.setText(String.valueOf(value));
                    break;
                case "category":
                    story.setCategory(String.valueOf(value));
                    break;
                case "numberLetters":
                    story.setNumberLetters(Integer.parseInt(String.valueOf(value)));
                    break;
                case "creationDate":
                    story.setCreationDate(LocalDateTime.parse(String.valueOf(value)));
                    break;

                default:
                    throw new StoryInvalidPatchParameterException(key);
            }
        });
        storyRepository.save(story);
        return getStoryOutDto(story);
    }

    @Override
    public void delete(long id) {
        getStoryOrFail(id);
        storyRepository.deleteById(id);
    }

    private Story getStoryOrFail(long id) {
        return storyRepository.findById(id).orElseThrow(() -> new StoryNotFoundException(id));
    }

    private StoryOutDto getStoryOutDto(Story story) {
        StoryOutDto out = new StoryOutDto();
        modelMapper.map(story, out);
        return out;
    }

    private List<StoryOutDto> getStoryOutDtos(List<Story> stories) {
        List<StoryOutDto> out = new ArrayList<>();
        stories.forEach(story -> out.add(getStoryOutDto(story)));
        return out;
    }
}
