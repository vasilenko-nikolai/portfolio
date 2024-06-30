package ru.vasilenkonikolai.portfolio.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasilenkonikolai.portfolio.models.Person;
import ru.vasilenkonikolai.portfolio.repositories.PeopleRepository;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PeopleRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public PeopleService(PeopleRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void savePerson(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        usersRepository.save(person);
    }



}
