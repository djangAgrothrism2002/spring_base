package com.vpbank.payment.domain.reposistories;

import com.vpbank.payment.domain.entities.User;
import com.vpbank.payment.domain.entities.UserLogins;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Function;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {
    @Override
    <S extends User> Optional<S> findOne(Example<S> example);

    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
}
