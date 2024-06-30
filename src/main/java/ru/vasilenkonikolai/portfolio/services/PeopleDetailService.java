package ru.vasilenkonikolai.portfolio.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasilenkonikolai.portfolio.models.Person;
import ru.vasilenkonikolai.portfolio.repositories.PeopleRepository;
import ru.vasilenkonikolai.portfolio.security.PersonDetails;

@Transactional(readOnly = true)
@Service
public class PeopleDetailService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    public PeopleDetailService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = peopleRepository.findByUsernameOrEmail(username, username);
        if (person == null) {
            throw new UsernameNotFoundException(username);
        }
        return new PersonDetails(person);
    }
}
