package com.api.ducklibras.services;

import com.api.springapi.models.dtos.UserInDto;
import com.api.springapi.models.entitys.UsersEntity;
import com.api.springapi.models.repos.InstitutesRepo;
import com.api.springapi.models.repos.UsersRepo;
import com.api.springapi.models.repos.VisitorsRepo;



@SpringBootTest
class CadServicesTests {

    @Mock
    private AlunoRepo AlunoiRepo;

    @InjectMocks
    private CadService cadServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(cadServices);
    }

    @Test
    void testCreateUsers_Success() {

        UserInDto user= new UserInDto("Lucas","email1@email.com");
        when(usersRepo.findByNameAndMail(user.getNames(), user.getMail())).thenReturn(Optional.empty());
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