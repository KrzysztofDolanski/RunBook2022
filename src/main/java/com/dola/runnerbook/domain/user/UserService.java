package com.dola.runnerbook.domain.user;

import com.dola.runnerbook.domain.user.dto.UserCredentialsDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserCredentialsDTO> findCredentialsByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserCredentialsDTOMapper::map);
    }
}
