package com.application.jobboard.user.service;

import com.application.jobboard.global.constant.SessionKey;
import com.application.jobboard.user.controller.dto.LoginRequestDto;
import com.application.jobboard.user.domain.User;
import com.application.jobboard.user.repository.UserRepository;
import com.application.jobboard.global.util.crypto.CryptoData;
import com.application.jobboard.global.util.crypto.Encryptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import jakarta.servlet.http.HttpSession;

@RequiredArgsConstructor
@Service
public class UserSessionLoginService implements LoginService {


    private final UserRepository userRepository;
    private final HttpSession httpSession;
    private final Encryptor encryptor;

    @Override
    public void login (LoginRequestDto dto) {
        if(!userRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new IllegalArgumentException("User does not exist");
        }
        Optional<User> user = userRepository.findByEmail(dto.getEmail());
        CryptoData cryptoData = CryptoData.WithSaltBuilder()
                .plainText(dto.getPassword())
                .salt(user.get().getUserSalt())
                .build();
        String encryptedPassword = encryptor.encrypt(cryptoData);

        if (!encryptedPassword.equals(user.get().getUserPassword())) {
            throw new IllegalArgumentException("Password is not correct");
        }
        httpSession.setAttribute(SessionKey.LOGIN_USER_ID, user.get().getUserId());
    }

    @Override
    public void logout () {
        httpSession.removeAttribute(SessionKey.LOGIN_USER_ID);
    }
    
    @Override
    public long getLoginUserId () {
        try {
            return (long) httpSession.getAttribute(SessionKey.LOGIN_USER_ID);
        } catch (NullPointerException e) {
            throw new NullPointerException("User is not logged in");
        }
    }


}
