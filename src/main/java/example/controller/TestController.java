package example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("/principal")
    public Principal principal(Principal principal) {
        return principal;
    }

    @GetMapping("/principal/auth")
    public Principal getPrincipalAtAuthentication() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return principal;
    }

    @GetMapping("/principal/principal")
    public Principal getPrincipalAtPrincipal() {
        // ClassCastException: User cannot be cast to Principal.
        Principal principal = (Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal;
    }

    // --------------------------------------------------------------------------------------------------

    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/auth/auth")
    public Authentication getAuthenticationAtAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

    @GetMapping("/auth/principal")
    public Authentication getAuthenticationAtPrincipal() {
        // ClassCastException: User cannot be cast to Authentication.
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return authentication;
    }

    // --------------------------------------------------------------------------------------------------

    @GetMapping("/user")
    public User user(@AuthenticationPrincipal User user) {
        return user;
    }

    @GetMapping("/user/auth")
    public User getUserAtAuthentication() {
        // ClassCastException: UsernamePasswordAuthenticationToken cannot be cast to User.
        User user = (User) SecurityContextHolder.getContext().getAuthentication();
        return user;
    }

    @GetMapping("/user/principal")
    public User getUserAtPrincipal() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }

    // --------------------------------------------------------------------------------------------------

    @GetMapping("/userdetails")
    public UserDetails userDetails(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }

    @GetMapping("/userdetails/auth")
    public UserDetails getUserDetailsAtAuthentication() {
        // ClassCastException: UsernamePasswordAuthenticationToken cannot be cast to UserDetails.
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication();
        return userDetails;
    }

    @GetMapping("/userdetails/principal")
    public UserDetails getUserDetailsAtPrincipal() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails;
    }

}
