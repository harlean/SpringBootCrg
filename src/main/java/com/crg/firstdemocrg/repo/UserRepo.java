package com.crg.firstdemocrg.repo;

import com.crg.firstdemocrg.domin.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User} {@link Repository}
 */


@Repository

public class UserRepo {

    private final static AtomicInteger idGenerator = new AtomicInteger();
    /**
     * 采用内存型存储方式  ——> Map
     */

    private final ConcurrentMap<Integer, User> repositity = new ConcurrentHashMap<>();

    /**
     * 保存用户对象
     *
     * @param user {@link User} 对象
     * @return 保存成功，返回<code>true</code>,
     * 否则返回<code>false</code>
     */

    public boolean save(User user) {
        //ID 从 1 开始
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repositity.put(id, user) == null;

    }


    /**
     * 返回所有用户列表
     *
     * @return
     */
    public Collection<User> findAll() {
        return repositity.values();

    }
}
