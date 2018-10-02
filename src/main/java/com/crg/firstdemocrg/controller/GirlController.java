package com.crg.firstdemocrg.controller;


import com.crg.firstdemocrg.domin.Girl;
import com.crg.firstdemocrg.domin.Result;
import com.crg.firstdemocrg.repo.GirlRepository;
import com.crg.firstdemocrg.service.GirlService;
import com.crg.firstdemocrg.until.ResultUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {


    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     *  查询整个列表
     * @return
     */
    @RequestMapping(value = "/girl")
    public List<Girl> girlList(){

        System.out.println(1);
        return girlRepository.findAll();

    }


    /**
     *
     * 添加一个女生
     *
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUntil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUntil.success(girlRepository.save(girl));
    }

    //查询一个女生
    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id);
    }

    //更新一个女生
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setName(name);
        girl.setAge(age);
        return girlRepository.saveAndFlush(girl);
    }

    //删除
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelte(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    @PostMapping("/girls/Two")
    public void girlTwo(){
         girlService.insertTwo();
    }

    @RequestMapping(value = "/girlAge/{id}")
    public Girl getAge(@PathVariable("id") Integer id) throws Exception{
        return girlService.findById(id);
    }




}
