package com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories;

import com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories.dto.StoryInDto;
import com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories.dto.StoryOutDto;
import com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories.model.Story;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins ="*")
public class StoryController {
    private static final String PATH = "/stories";
    private final Logger log = LoggerFactory.getLogger(StoryController.class);

    @Autowired
    private StoryService storyService;

    @GetMapping(PATH)
    public ResponseEntity<List<StoryOutDto>> get() {
        return ResponseEntity.ok(storyService.get());
    }

    @PostMapping(PATH)
    public ResponseEntity<StoryOutDto> post(@RequestBody StoryInDto storyInDto) throws URISyntaxException {
        StoryOutDto storyOutDto = storyService.post(storyInDto);
        return ResponseEntity
                .created(new URI(PATH + "/" + storyOutDto.getId()))
                .body(storyOutDto);
    }

    @GetMapping(PATH + "/{id}")
    public ResponseEntity<StoryOutDto> get(@PathVariable long id) {
        StoryOutDto storyOutDto = storyService.get(id);
        return ResponseEntity.ok(storyOutDto);
    }

    @DeleteMapping(PATH + "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        storyService.delete(id);
        log.info("Story removed / Relato corto eliminado");
        return ResponseEntity.noContent().build();
    }

    @PutMapping(PATH + "/{id}")
    public ResponseEntity<StoryOutDto> put(@PathVariable long id,
                                          @RequestBody StoryInDto storyInDto) {
        return ResponseEntity.ok(storyService.put(id, storyInDto));
    }

    @PatchMapping(PATH + "/{id}")
    public ResponseEntity<StoryOutDto> patch(@PathVariable long id,
                                            @RequestBody Map<String, Object> patchParameters) {
        StoryOutDto storyOutDto = storyService.patch(id, patchParameters);
        log.info("Story modified/Relato modificado");
        return ResponseEntity.ok(storyOutDto);
    }

}
