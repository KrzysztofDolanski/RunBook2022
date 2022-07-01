package com.dola.runnerbook.domain.user;

import com.dola.runnerbook.domain.user.dto.UserCredentialsDTO;

import java.util.Set;
import java.util.stream.Collectors;

public class UserCredentialsDTOMapper {

    static UserCredentialsDTO map(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        Set<String> roles = user.getRoles()
                .stream()
                .map(UserRole::getName)
                .collect(Collectors.toSet());
        return new UserCredentialsDTO(email, password, roles);
    }
}
