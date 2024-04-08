package com.ulisses.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ulisses.users.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
