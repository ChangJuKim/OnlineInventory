package io.onlineinventory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hello")
    public String sayHi() {
        return "Hi";
    }

    /*
     * @RequestMapping("/hello")
     * public String sayHiTwo() {
     * return "HiTwo!";
     * }
     */
}
