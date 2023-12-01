/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.volationsNo.UserFilter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author ЦОПП
 */
public class СhekedUserDoFilter implements Filter {

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // Инициализация фильтра
//    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // Проверяем, авторизован ли пользователь
        if (request.getSession().getAttribute("user") == null) {
            // Если не авторизован, перенаправляем на страницу регистрации
            response.sendRedirect(request.getContextPath() + "/loginUser.html");
        } else {
            // Если авторизован, продолжаем обработку запроса
            filterChain.doFilter(request, response);
        }
    }

//    @Override
//    public void destroy() {
//        // Выполнение очистки при завершении фильтра
//    }
}
