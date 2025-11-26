package com.capgemini.CourseManagementSysstem.service;

import com.capgemini.CourseManagementSysstem.dto.AuthRequest;
import com.capgemini.CourseManagementSysstem.dto.AuthResponse;
import com.capgemini.CourseManagementSysstem.dto.RegisterRequest;
import com.capgemini.CourseManagementSysstem.entity.Role;
import com.capgemini.CourseManagementSysstem.entity.User;
import com.capgemini.CourseManagementSysstem.repository.RoleRepository;
import com.capgemini.CourseManagementSysstem.repository.UserRepository;
import com.capgemini.CourseManagementSysstem.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthResponse login(AuthRequest req){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(),req.getPassword())
        );
        UserDetails ud = (UserDetails) authentication.getPrincipal();
        String token = jwtUtil.generateToken(ud);
        return new AuthResponse(token);
    }

    public AuthResponse register(RegisterRequest req) {
        if (userRepository.findByUsername(req.getUsername()).isPresent()) {
            throw new RuntimeException("Username already taken");
        }
        User u = User.builder()
                .username(req.getUsername())
                .password(passwordEncoder.encode(req.getPassword()))
                .email(req.getEmail())
                .build();

        // assign default role ROLE_USER
        Role userRole = roleRepository.findByName("ROLE_USER").orElseGet(() -> roleRepository.save(new Role(null, "ROLE_USER")));
        u.getRoles().add(userRole);
        userRepository.save(u);

        UserDetails ud = new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(),
                u.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toSet()));
        String token = jwtUtil.generateToken(ud);
        return new AuthResponse(token);
    }
}
