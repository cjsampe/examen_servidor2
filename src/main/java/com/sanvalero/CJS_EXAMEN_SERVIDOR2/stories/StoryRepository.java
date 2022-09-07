package com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories;

import com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories.model.Story;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends CrudRepository<Story, Long> {
    List<Story> findAll();
    List<Story> findByCategory(String category);
}
