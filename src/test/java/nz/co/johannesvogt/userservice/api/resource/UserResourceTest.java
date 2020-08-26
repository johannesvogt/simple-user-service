package nz.co.johannesvogt.userservice.api.resource;

import nz.co.johannesvogt.userservice.model.User;
import nz.co.johannesvogt.userservice.repository.UserRepository;
import nz.co.johannesvogt.userservice.spec.model.UserInfo;
import nz.co.johannesvogt.userservice.spec.model.UserInfoResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static java.util.stream.Collectors.toList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserResourceTest {

    @Mock
    private UserRepository userRepositoryMock;

    private UserResource userResource;

    @Before
    public void init() {
        userResource = new UserResource(userRepositoryMock);
    }

    @Test
    public void testGetUserNullInput() {

        when(userRepositoryMock.findAll()).thenReturn(users("John Smith", "Frank Meyer"));

        assertThat(userResource.getUser(null)).isEqualTo(userInfoResponse("John Smith", "Frank Meyer"));

        verify(userRepositoryMock, times(1)).findAll();
        verify(userRepositoryMock, times(0)).findBySurnameContainingIgnoreCase(any());

    }

    @Test
    public void testGetUserWithSurname() {

        when(userRepositoryMock.findBySurnameContainingIgnoreCase("smith")).thenReturn(users("John Smith", "Frank smith"));

        assertThat(userResource.getUser("smith")).isEqualTo(userInfoResponse("John Smith", "Frank smith"));

        verify(userRepositoryMock, times(0)).findAll();
        verify(userRepositoryMock, times(1)).findBySurnameContainingIgnoreCase("smith");
    }

    private List<User> users(String... names) {
        return Arrays.stream(names).map(name -> {
                    User user = new User();
                    user.setId(1L);
                    user.setFirstname(name.split(" ")[0]);
                    user.setSurname(name.split(" ")[1]);
                    user.setEmail(name.replace(" ", "") + "@hotmail.com");
                    return user;
                }
        ).collect(toList());
    }

    private UserInfoResponse userInfoResponse(String... names) {
        return new UserInfoResponse().userinfos(Arrays.stream(names).map(name ->
                new UserInfo()
                        .firstname(name.split(" ")[0])
                        .surname(name.split(" ")[1])
                        .email(name.replace(" ", "") + "@hotmail.com")
        ).collect(toList()));
    }

}
