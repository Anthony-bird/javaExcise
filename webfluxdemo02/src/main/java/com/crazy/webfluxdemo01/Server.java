package com.crazy.webfluxdemo01;

import com.crazy.webfluxdemo01.handler.UserHandler;
import com.crazy.webfluxdemo01.service.UserService;
import com.crazy.webfluxdemo01.service.impl.UserServiceImpl;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

public class Server {

    public static void main(String[] args) throws Exception{
        Server server = new Server();
        server.creatReactorServer();
        System.out.println("enter to exit");
        System.in.read();
    }

    //1.创建Router路由
    public RouterFunction<ServerResponse> routerFunction() {
        //创建Handler对象
        UserService userService = new UserServiceImpl();
        UserHandler handler = new UserHandler(userService);
        //设置路由器
        return RouterFunctions.route(
                GET("/users/{id}").and(accept(APPLICATION_JSON)),handler::getUserById)
                .andRoute( GET("/users").and(accept(APPLICATION_JSON)),handler::getAllUsers);
    }

    //2创建服务器完成适配
    public void creatReactorServer() {
        //路由和Handler适配
        RouterFunction<ServerResponse> router = routerFunction();
        HttpHandler httpHandler = toHttpHandler(router);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        //创建服务器
        HttpServer httpServer = HttpServer.create();
        httpServer.handle(adapter).bindNow();
    }
}
