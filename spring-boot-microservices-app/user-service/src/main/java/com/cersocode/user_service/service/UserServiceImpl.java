package com.cersocode.user_service.service;

import com.cersocode.user_service.dto.DepartmentDto;
import com.cersocode.user_service.dto.ResponseDto;
import com.cersocode.user_service.dto.UserDto;
import com.cersocode.user_service.entity.User;
import com.cersocode.user_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private APIClient apiClient;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUser(Long userId) {
        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).get();
        UserDto userDto = mapToUser(user);
        responseDto.setUser(userDto);

        DepartmentDto departmentDto = apiClient.getDepartmentById(user.getDepartmentId());
        responseDto.setDepartment(departmentDto);

        return responseDto;
    }

    private UserDto mapToUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
