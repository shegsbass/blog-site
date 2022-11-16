package dev.shegs.blogsite.service;

import dev.shegs.blogsite.models.UserAccount;

import java.util.Optional;

public interface UserAccountService {

    UserAccount saveUser(UserAccount userAccount);

    Optional <UserAccount> findOneByEmail (String email);

}
