package com.cersocode.user_service.service;

import com.cersocode.user_service.dto.ResponseDto;
import com.cersocode.user_service.entity.User;

public interface UserService {
    User saveUser(User user);
    ResponseDto getUser(Long userId);
}
