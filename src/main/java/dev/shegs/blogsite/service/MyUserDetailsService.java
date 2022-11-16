package dev.shegs.blogsite.service;

import dev.shegs.blogsite.models.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAccountService userAccountService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Optional<UserAccount> optionalUserAccount = userAccountService.findOneByEmail(email);
        if (!optionalUserAccount.isPresent()){
            throw new UsernameNotFoundException("Account Not Found!");
        }

        UserAccount userAccount = optionalUserAccount.get();

        List <GrantedAuthority> grantedAuthorities = userAccount
                .getAuthorities()
                .stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(userAccount.getEmail(), userAccount.getPassword(), grantedAuthorities);
    }
}
