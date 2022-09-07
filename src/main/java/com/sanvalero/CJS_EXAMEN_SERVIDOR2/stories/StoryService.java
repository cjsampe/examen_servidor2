package com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories;

import com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories.dto.StoryInDto;
import com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories.dto.StoryOutDto;
import com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories.model.Story;

import java.util.List;
import java.util.Map;

public interface StoryService {
    List<StoryOutDto> get();

    StoryOutDto get(long id);

    List<Story> findByCategory(String category);

    StoryOutDto post(StoryInDto storyInDto);
    StoryOutDto put(long id, StoryInDto storyInDto);
    StoryOutDto patch(long id, Map<String, Object> patchParameters);
    void delete(long id);

}
