package org.orientalites.SmartSchool.data.service;

import java.util.Optional;
import org.orientalites.SmartSchool.data.dao.StudentRepository;
import org.orientalites.SmartSchool.data.models.CustomUserDetails;
import org.orientalites.SmartSchool.data.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentDetailService implements UserDetailsService {

    @Autowired private StudentRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<Student> user = repo.findByEmail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("user not found");
        } else {
            return new CustomUserDetails(user.get());
        }
    }
}
