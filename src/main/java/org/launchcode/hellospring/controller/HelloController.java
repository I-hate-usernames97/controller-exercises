package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@Controller
@RequestMapping("hello")
public class HelloController {

    @GetMapping("goodbye")
    public String goodBye(){
        return "Goodbye, Spring!";
    }

    @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloWithQuerParm(@RequestParam String name, String  language) {

        if (Objects.equals(language, "")) {
            return "Hello, " + name + "!";
        }
        return language + ", " + name + "!";
    }

    @GetMapping("{name}")
    public String helloWithPathParm(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(Model model){
        HashMap<String, String> options = new HashMap();
        options.put("French", "Bonjour");
        options.put("Spanish", "Hola");
        options.put("Italian", "Ciao");
        options.put("Japanese", "Konnichiwa");
        options.put("Korean", "Annyeonghaseyo");
        options.put("Mandarin", "Nihau");
        options.put("JOJO", " Hi There");
        model.addAttribute("options", options);
        return "form";
    }

}
