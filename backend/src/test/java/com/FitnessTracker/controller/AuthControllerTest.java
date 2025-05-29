//package com.FitnessTracker.controller;
//
//import com.fitnesstracker.controller.AuthController;
//import com.fitnesstracker.dto.AuthRequest;
//import com.fitnesstracker.model.User;
//import com.fitnesstracker.service.UserService;
//import com.fitnesstracker.util.JwtUtil;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.mockito.ArgumentMatchers.any;
//
//@WebMvcTest(AuthController.class)
//public class AuthControllerTest {
//
//    @MockBean
//    private UserService userService;
//
//    @MockBean
//    private JwtUtil jwtUtil;
//
//    @InjectMocks
//    private AuthController authController;
//
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
//    }
//
//    @Test
//    public void testSignup() throws Exception {
//        User user = new User("John Doe", "john@example.com", "password");
//        when(userService.save(any(User.class))).thenReturn(user);
//        when(jwtUtil.generateToken(any(String.class))).thenReturn("mock-jwt-token");
//
//        mockMvc.perform(post("/auth/signup")
//                        .contentType("application/json")
//                        .content("{ \"email\": \"john@example.com\", \"password\": \"password\", \"name\": \"John Doe\" }"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.token").value("mock-jwt-token"));
//    }
//
//    @Test
//    public void testLogin() throws Exception {
//        AuthRequest authRequest = new AuthRequest("john@example.com", "password");
//        User user = new User("John Doe", "john@example.com", "password");
//        when(userService.getByEmail("john@example.com")).thenReturn(java.util.Optional.of(user));
//        when(userService.checkPassword("password", user.getPassword())).thenReturn(true);
//        when(jwtUtil.generateToken(any(String.class))).thenReturn("mock-jwt-token");
//
//        mockMvc.perform(post("/auth/login")
//                        .contentType("application/json")
//                        .content("{ \"email\": \"john@example.com\", \"password\": \"password\" }"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.token").value("mock-jwt-token"));
//    }
//
//    @Test
//    public void testLoginInvalidCredentials() throws Exception {
//        AuthRequest authRequest = new AuthRequest("lincoln@gmail.com", "wrongpassword");
//        User user = new User("Lincoln Rao", "lincoln@gmail.com", "password");
//        when(userService.getByEmail("lincoln@gmail.com")).thenReturn(java.util.Optional.of(user));
//        when(userService.checkPassword("wrongpassword", user.getPassword())).thenReturn(false);
//
//        mockMvc.perform(post("/auth/login")
//                        .contentType("application/json")
//                        .content("{ \"email\": \"lincoln@gmail.com\", \"password\": \"wrongpassword\" }"))
//                .andExpect(status().isUnauthorized());
//    }
//}
