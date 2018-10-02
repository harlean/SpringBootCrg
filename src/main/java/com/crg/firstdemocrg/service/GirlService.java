package com.crg.firstdemocrg.service;


import com.crg.firstdemocrg.domin.Girl;
import com.crg.firstdemocrg.enums.ResultEnum;
import com.crg.firstdemocrg.exception.GirlException;
import com.crg.firstdemocrg.repo.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){

        Girl girlA = new Girl();
        girlA.setAge(15);
        girlA.setName("小红");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(171);
        girlB.setName("小明");
        girlRepository.save(girlB);
    }


    public Girl findById(Integer id) throws Exception{

        Optional<Girl> girl = girlRepository.findById(id);
         Integer age = girl.get().getAge();
        if(age < 10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 19){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        return girl.get();
    }


    /**
     * 通过Id查询女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        Optional<Girl> girl =  girlRepository.findById(id);
        return girl.get();
    }
}
