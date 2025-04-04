package com.api.ducklibras.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ducklibras.api.models.dtos.AlunoInDto;
import com.ducklibras.api.models.entitys.AlunoEntitys;
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
        when(AlunoRepo.findByUsernameAndEmail(user.getUsername(), user.getEmail())).thenReturn(Optional.empty());
        AlunoEntitys AlunoEntitys = new AlunoEntitys(user);
        when(AlunoRepo.save(any(AlunoEntitys.class))).thenReturn(AlunoEntitys);
        AlunoEntitys result = CadService.createUsers(user);
        assertNotNull(result);
        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getEmail(), result.getEmail());
        verify(AlunoRepo, times(1)).save(any(AlunoEntitys.class));
    }

    @Test
    void testValidateUsers_UserExist() {
        String username = "Lucas";
        String email = "email1@email.com";
        when(AlunoRepo.findByUsernameAndEmail(username, email)).thenReturn(Optional.empty());
        boolean result = CadService.ValidateUsers(username, email);
        assertTrue(result);
        verify(AlunoRepo, times(1)).findByUsernameAndEmail(username, email);
    }

}