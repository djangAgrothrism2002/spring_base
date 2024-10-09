package com.vpbank.payment.domain.reposistories;

import com.vpbank.payment.domain.entities.UserLogins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserLoginsRepo extends JpaRepository<UserLogins, Long> {
    Optional<UserLogins> findByUsername (String username);

    @Override
    UserLogins save(UserLogins userLogins);

}
