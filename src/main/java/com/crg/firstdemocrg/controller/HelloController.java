package com.crg.firstdemocrg.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

   @Autowired
   private GirlProperties girlProperties;


   //@RequestParam 取问号参数
    @RequestMapping(value = "/say/{id}",method = RequestMethod.GET)
    public String index(@PathVariable("id") Integer id){
        return "id:" + id;
    }


    //@RequestParam 取问号参数
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String Hello(@RequestParam(value ="id",required = false,defaultValue = "0") Integer myid){
        return "id:" + myid;
    }

}
