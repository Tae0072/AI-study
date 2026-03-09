package com.example.demo2.user;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(UserRequest.Join reqDTO) {
        User user = User.builder()
                .username(reqDTO.getUsername())
                .password(reqDTO.getPassword())
                .email(reqDTO.getEmail())
                .zipcode(reqDTO.getZipcode())
                .address(reqDTO.getAddress())
                .detailAddress(reqDTO.getDetailAddress())
                .build();
        userRepository.save(user);
    }

    public User 로그인(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("아이디를 찾을 수 없습니다"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("패스워드가 일치하지 않습니다");
        }

        return user;
    }

}
