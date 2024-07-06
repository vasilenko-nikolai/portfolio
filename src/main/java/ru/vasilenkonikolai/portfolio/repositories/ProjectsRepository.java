package ru.vasilenkonikolai.portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vasilenkonikolai.portfolio.models.Project;

@Repository
public interface ProjectsRepository extends JpaRepository<Project, Integer> {}
