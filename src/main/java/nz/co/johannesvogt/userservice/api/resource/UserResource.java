package nz.co.johannesvogt.userservice.api.resource;

import nz.co.johannesvogt.userservice.model.User;
import nz.co.johannesvogt.userservice.repository.UserRepository;
import nz.co.johannesvogt.userservice.spec.model.UserInfo;
import nz.co.johannesvogt.userservice.spec.model.UserInfoResponse;
import nz.co.johannesvogt.userservice.spec.resource.UserApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class UserResource implements UserApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    private UserRepository userRepository;

    @Autowired
    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserInfoResponse getUser(String surname) {
        if (surname == null) {
            LOGGER.info("Return all users");
            return toUserInfoResponse(userRepository.findAll());
        }

        LOGGER.info("Return users matching surname " + surname);
        return toUserInfoResponse(userRepository.findBySurnameContainingIgnoreCase(surname));
    }

    private UserInfoResponse toUserInfoResponse(List<User> users) {
        return new UserInfoResponse().userinfos(
                users.stream().map(user -> new UserInfo()
                                .firstname(user.getFirstname())
                                .surname(user.getSurname())
                                .email(user.getEmail()))
                        .collect(toList())
        );
    }
}
