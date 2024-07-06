package ru.vasilenkonikolai.portfolio.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasilenkonikolai.portfolio.models.Project;
import ru.vasilenkonikolai.portfolio.repositories.ProjectsRepository;

@Service
@Transactional(readOnly = true)
public class ProjectsService {
    private final ProjectsRepository projectsRepository;

    public ProjectsService(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    public void save(Project project) {
        projectsRepository.save(project);
    }

}
