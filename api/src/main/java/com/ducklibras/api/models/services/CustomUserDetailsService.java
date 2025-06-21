package com.ducklibras.api.models.services;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ducklibras.api.models.entitys.AlunoEntitys;
import com.ducklibras.api.models.repo.AlunoRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final AlunoRepo alunoRepo;
    public CustomUserDetailsService(AlunoRepo alunoRepo) {
        this.alunoRepo = alunoRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AlunoEntitys aluno = alunoRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        Set<GrantedAuthority> authorities = Set.of(new SimpleGrantedAuthority("ROLE_USER"));

        return new org.springframework.security.core.userdetails.User(
                aluno.getEmail(),
                aluno.getPass(),
                authorities
        );
    }


   
}