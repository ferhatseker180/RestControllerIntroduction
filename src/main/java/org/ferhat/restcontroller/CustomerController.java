package org.ferhat.restcontroller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/")
    public String get() {
        return "Customer Get Methodu Çalıştı";
    }

    @PostMapping("/save")
    public String save(@RequestBody String data) {
        return "Gelen Veri: " + data;
    }
}
