package ru.vasilenkonikolai.portfolio.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vasilenkonikolai.portfolio.dto.LoginDto;
import ru.vasilenkonikolai.portfolio.models.Person;
import ru.vasilenkonikolai.portfolio.services.PeopleService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final PeopleService peopleService;

    private final AuthenticationManager authenticationManager;
    private final SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();

    public AuthController(PeopleService peopleService, AuthenticationManager authenticationManager) {
        this.peopleService = peopleService;
        this.authenticationManager = authenticationManager;
    }

    private SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();

    @PostMapping("/register")
    public String register(@RequestBody @Valid Person person, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return String.join(" and ", bindingResult.getAllErrors().stream().map(ObjectError::toString).toList());
        }
        peopleService.savePerson(person);
        return "Успешно";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto dto, HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                dto.getLogin(), dto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken.unauthenticated(dto.getLogin(), dto.getPassword());
        authentication = authenticationManager.authenticate(token);
        SecurityContext context = securityContextHolderStrategy.createEmptyContext();
        context.setAuthentication(authentication);
        securityContextHolderStrategy.setContext(context);
        securityContextRepository.saveContext(context, request, response);
        return "Успешно";
    }

}
