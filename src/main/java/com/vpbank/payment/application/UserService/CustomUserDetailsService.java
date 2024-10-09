package com.vpbank.payment.application.UserService;

import com.vpbank.payment.api.dao.requests.AuthenticationRequest;
import com.vpbank.payment.domain.entities.UserLogins;
import com.vpbank.payment.domain.reposistories.IUserLoginsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomUserDetailsService  implements UserDetailsService {
    @Autowired
    private IUserLoginsRepo iUserLoginsRepo;

    @Override
    public AuthenticationRequest loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserLogins> user = iUserLoginsRepo.findByUsername(username);
        return new AuthenticationRequest(user.get().getUsername(), user.get().getPassword());
    }
}
