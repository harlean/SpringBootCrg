package com.crg.firstdemocrg.config;


import com.crg.firstdemocrg.domin.User;
import com.crg.firstdemocrg.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * 路由函数
 */

@Configuration
public class RouterFunctionConfigration {
    /**
     * Servlet
     *    请求接口： ServletRequest 或者 HtppServletRequest
     *    响应接口： ServletRepose 或者 HttpServletRepose
     *    Spring 5 重新定义了服务请求与响应接口
     *    请求接口：ServerRequest
     *    响应接口： ServerRepose
     *    即可支持Servlet 规范也可支持 自定义，比如Netty Web Server
     *
     *    以本例子：
     *    定义 Get 请求，并且返回所有的用户对象（URL：person/find/all）
     *    Flux  是 0 - N 个对象集合
     *    Mono 是 0 - 1 个对象集合
     *    Recative  中的 Flux 或者 Mono 是异步处理（非阻塞）
     *    集合对象基本上是同步处理（阻塞）
     *    Flux 或者 Mono 都是Publisher
     */

//    @Bean
//    @Autowired
//    public RouterFunction<ServerResponse> personFindAll(UserRepo userRepo){
//
//        //返回所有的用户对象
//        String pattern = "/person/find/all";
//
//        return RouterFunctions.route(RequestPredicates.GET(pattern),
//                       request -> {
//                                   Collection<User>  users = userRepo.findAll();
//                                   Flux<User> userFlux = Flux.fromIterable(users);
//                                   return ServerResponse.ok().body(userFlux,User.class);
//                               });
//    }
}
