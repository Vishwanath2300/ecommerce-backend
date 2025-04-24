package com.catalogue.ecommerce.Repository;


import com.catalogue.ecommerce.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;

@Repository
public interface userRepository extends JpaRepository<Users,Long> {

    Users findAllByUsername(String username);
}
