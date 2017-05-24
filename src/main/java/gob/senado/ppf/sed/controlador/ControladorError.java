package gob.senado.ppf.sed.controlador;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created by Administrador on 23/05/2017.
 */
@ControllerAdvice
//@Controller
public class ControladorError {
    String path = "/codigo-error";

//    @RequestMapping(value="/400")
//    public String error400(){
//        System.out.println("custom error handler");
//        return path+"/400";
//    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String error404() {
        System.out.println("custom error handler");
        return path + "/404";
    }

//    @RequestMapping(value = "/403")
//    public String error403() {
//        System.out.println("custom error handler");
//        return path + "/403";
//    }

//    @RequestMapping(value="/500")
//    public String error500(){
//        System.out.println("custom error handler");
//        return path+"/500";
//    }
}
