package com.bogdan_yanushkevich.javacore.rest.controller;

import com.bogdan_yanushkevich.javacore.rest.model.User;
import com.bogdan_yanushkevich.javacore.rest.service.UserService;
import com.bogdan_yanushkevich.javacore.rest.util.GsonUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class UserRestControllerV1 extends HttpServlet {


    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        int id = userMapping(request);
        if (id == 0) {
            List<User> users = userService.getAll();
            GsonUtil.writeToJson(response, users);
        } else {
            User user = userService.getById(id);
            GsonUtil.writeToJson(response, user);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getHeader("user_name");
        User user = userService.save(name);
        GsonUtil.writeToJson(response, user);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        int id = userMapping(request);
        String name = request.getHeader("user_name");
        User user = userService.update(id, name);
        GsonUtil.writeToJson(response, user);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        int id = userMapping(request);
        userService.delete(id);
        GsonUtil.writeToJson(response, "User with id = " + id + " was deleted");
    }

    private Integer userMapping(HttpServletRequest request) throws UnsupportedEncodingException {
        String urlPattern = "/api/v1/users/";
        request.setCharacterEncoding("UTF-8");
        String url = request.getRequestURL().toString();
        String id = url.substring(url.indexOf(urlPattern) + urlPattern.length());
        if (id.isBlank()) {
            return 0;
        } else {
            return Integer.parseInt(id);
        }
    }
}
