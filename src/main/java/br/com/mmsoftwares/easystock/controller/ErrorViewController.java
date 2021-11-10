package br.com.mmsoftwares.easystock.controller;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class ErrorViewController implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {

        ModelAndView modelAndView = new ModelAndView("/error");

        modelAndView.addObject("status", status.value());

        switch (status.value()){
            case 404:
                modelAndView.addObject("error", "Página não encontrada.");
                modelAndView.addObject("message", "A página solicitada não está disponível ou é inexistente.");
                break;
            case 500:
                modelAndView.addObject("error", "Erro interno do servidor, tente mais tarde.");
                modelAndView.addObject("message", "Ocorreu um erro interno no servidor. O servidor pode estar sobrecarregado ou " +
                        "ocorreu uma falha ao processar. Tente mais tarde.");
                break;
            default:
                modelAndView.addObject("error", model.get("error"));
                modelAndView.addObject("message", model.get("message"));
                break;
        }
        return modelAndView;
    }
}
