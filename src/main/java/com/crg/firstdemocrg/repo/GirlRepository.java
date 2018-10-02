package com.crg.firstdemocrg.repo;

import com.crg.firstdemocrg.domin.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface GirlRepository extends JpaRepository<Girl,Integer> {


    @Modifying
    @Query(value = "update Student set name=?2 where id=?1 ", nativeQuery = true)
    public void updateA(@RequestParam("id") Integer id, @RequestParam("name") String name);
}
