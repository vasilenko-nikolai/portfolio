package ru.vasilenkonikolai.portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vasilenkonikolai.portfolio.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    Person findByUsernameOrEmail(String username, String email);
}
