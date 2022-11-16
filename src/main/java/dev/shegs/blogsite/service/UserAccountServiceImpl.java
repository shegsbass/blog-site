package dev.shegs.blogsite.service;

import dev.shegs.blogsite.models.Authority;
import dev.shegs.blogsite.models.UserAccount;
import dev.shegs.blogsite.repository.AuthorityRepository;
import dev.shegs.blogsite.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserAccountServiceImpl implements UserAccountService{

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserAccount saveUser(UserAccount userAccount) {

        if (userAccount.getId() == null) {
            if (userAccount.getAuthorities().isEmpty()) {
                Set<Authority> authorities = new HashSet<>();
                authorityRepository.findById("ROLE_USER").ifPresent(authorities::add);
                userAccount.setAuthorities(authorities);
            }
        }

        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        return userAccountRepository.save(userAccount);
    }

    @Override
    public Optional<UserAccount> findOneByEmail(String email) {
        return userAccountRepository.findOneByEmailIgnoreCase(email);
    }


}
