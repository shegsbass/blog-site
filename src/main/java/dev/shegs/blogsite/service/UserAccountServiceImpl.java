package dev.shegs.blogsite.service;

import dev.shegs.blogsite.models.UserAccount;
import dev.shegs.blogsite.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService{

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserAccount saveUser(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }
}
