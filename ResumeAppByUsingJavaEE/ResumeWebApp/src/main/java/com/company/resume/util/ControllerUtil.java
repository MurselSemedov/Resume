package com.company.resume.util;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerUtil {
    public static void errorPage(HttpServletResponse response, Exception ex,String back){
        ex.printStackTrace();
        try {
            response.sendRedirect("error?msg=" + ex.getMessage()+"&back="+back);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
