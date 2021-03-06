package example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String ignoreSecurity() {
        return "Spring Security ignoring Test";
    }

    /*
    @GetMapping
    public Principal responsePrincipal(Principal principal) {
        return principal;
    }
    */
}
