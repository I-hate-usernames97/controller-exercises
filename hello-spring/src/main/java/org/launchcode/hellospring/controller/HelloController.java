package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    @GetMapping("goodbye")
    public String goodBye(){
        return "Goodbye, Spring!";
    }

    @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
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
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" +
                "<input type='text' name='name' value= name " +
                "<label for=\"language-select\"></label>\n" +
                "\n" +
                "<select name=\"language\" id=\"language-select\">\n" +
                "    <option value=\"\">--Please choose an option--</option>\n" +
                "    <option value=\"Bonjour\">French</option>\n" +
                "    <option value=\"Hola\">Spanish</option>\n" +
                "    <option value=\"Ciao\">Italian</option>\n" +
                "    <option value=\"Konnichiwa\">Japanese</option>\n" +
                "    <option value=\"Annyeonghaseyo\">Korean</option>\n" +
                "    <option value=\"Nihau\n" + "\n\">Mandarin</option>\n" +
                "</select> " +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
