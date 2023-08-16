package com.ahmetakkoyun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    // http metotları :
    // Get
    // Post
    // Put
    // Delete

    @GetMapping
    public String hello(){
        return "Hello";
    }

    @GetMapping("/getname")
    public String getName(){
        return "Ahmet";
    }

    @GetMapping("/getname1")
    public String getName2(String name){
        return "<style> .myname{color:red}</style> <div class='myname'>"+name+"</div>";
    }  // bunu test etmek için browserda localhost:8080/demo/getname1?name=ali yaz. veya başka bir isim.

    @GetMapping("/getname2")
    public String getName2(String name, String surname){
        return "<style> .myname{color:red}</style> <div class='myname'>"+name+"-"+surname+"</div>";
    }  // bunu test etmek için browserda localhost:8080/demo/getname2?name=ali&surname=veli yaz. veya başka bir isim soyisim

    @GetMapping("/get_list")
    public List<String> get_list(){
        String name1 = "Mustafa";
        String name2 = "Sena";
        String name3 = "Derya";
        return List.of(name1, name2, name3);
    }


}
