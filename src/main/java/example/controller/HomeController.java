package example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
@Slf4j
public class HomeController {

    @GetMapping
    public Principal responsePrincipal(Principal principal) {
        return principal;
    }
}
