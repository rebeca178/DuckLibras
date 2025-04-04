package com.api.ducklibras.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ducklibras.api.models.repo.AlunoRepo;
import com.ducklibras.api.services.CadService;



@SpringBootTest
class CadServicesTests {

    @Mock
    private AlunoRepo AlunoRepo;

    @InjectMocks
    private CadService CadService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(CadService);
    }

    @Test
    void testCreateUsers_Success() {

        AlunoInDto user= new AlunoInDto("Lucas","email1@email.com");
        when(AlunoRepo.findByNameAndMail(user.getNames(), user.getMail())).thenReturn(Optional.empty());
        UsersEntity userEntity = new UsersEntity(user);
        when(usersRepo.save(any(UsersEntity.class))).thenReturn(userEntity);
        UsersEntity result = cadServices.createUsers(user);
        assertNotNull(result);
        assertEquals(user.getNames(), result.getNames());
        assertEquals(user.getMail(), result.getMail());
        verify(usersRepo, times(1)).save(any(UsersEntity.class));
    }

    @Test
    void testValidateUsers_UserExist() {
        String name = "Lucas";
        String mail = "email1@email.com";
        when(usersRepo.findByNameAndMail(name, mail)).thenReturn(Optional.empty());
        boolean result = cadServices.ValidateUsers(name, mail);
        assertTrue(result);
        verify(usersRepo, times(1)).findByNameAndMail(name, mail);
    }

}