//package com.pomotask.pomotask.service;
//
//
//import com.pomotask.pomotask.builder.UserFormBuilder;
//import com.pomotask.pomotask.domain.UserEntity;
//import com.pomotask.pomotask.dto.form.UserForm;
//import com.pomotask.pomotask.dto.mapper.UserMapper;
//import com.pomotask.pomotask.dto.view.UserView;
//import com.pomotask.pomotask.repository.UserRepository;
//import com.pomotask.pomotask.service.exception.ObjectNotFoundException;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Spy;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.is;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class UserServiceTest {
//
//    private static final long INVALID_USER_ID = 1L;
//    @Mock
//    private UserRepository repo;
//    @InjectMocks
//    private UserService service;
//    @Spy
//    private UserMapper mapper;
//
//
//    @Test
//    void whenUserNotFoundByEmailThenUserShouldBeCreated() {
//
//        UserForm expectedUserForm = UserFormBuilder.builder().build().toForm();
//        UserEntity expectedSavedUser = mapper.toModel(expectedUserForm);
//
//        when(repo.save(new UserEntity(expectedSavedUser.getEmail())))
//                .thenReturn(new UserEntity(expectedSavedUser.getEmail()));
//
//        UserView view = service.findViewByEmail(expectedSavedUser.getEmail());
//        assertThat(view.getEmail(), is(equalTo(expectedSavedUser.getEmail())));
//
//    }
//
//    @Test
//    void whenExclusionIsCalledWithValidIdAndEmailThenAUserShouldBeDeleted() throws ObjectNotFoundException {
//        UserForm expectedDeletedUserForm = UserFormBuilder.builder().build().toForm();
//        UserEntity expectedDeletedUser = mapper.toModel(expectedDeletedUserForm);
//
//        when(repo.findByEmail(expectedDeletedUserForm.getEmail()))
//                .thenReturn(Optional.of(expectedDeletedUser));
//        doNothing().when(repo).deleteById(expectedDeletedUserForm.getId());
//
//        service.deleteByIdAndEmail(expectedDeletedUserForm.getId(), expectedDeletedUser.getEmail());
//
//        verify(repo, times(1)).findByEmail(expectedDeletedUserForm.getEmail());
//        verify(repo, times(1)).deleteById(expectedDeletedUserForm.getId());
//    }
//
//}
