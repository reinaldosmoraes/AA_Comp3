package roteiroTransacao;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistencia.LoginMD;

public class LoginRT {
	
	public void tratar(String email, HttpServletResponse response, HttpServletRequest request) throws IOException{
		if(validar(email)){
		LoginMD md;
		try {
			md = new LoginMD();
			int i = md.logar(email);
			HttpSession sessao = request.getSession();
			sessao.setAttribute("email", email);
			sessao.setAttribute("motorista", i);
			if(i == 0){
				response.sendRedirect("index-usuario.jsp");}
			else if(i == 1){
			response.sendRedirect("index-motorista.jsp");}
			else{
			response.sendRedirect("index.jsp");}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			response.sendRedirect("erro.jsp");
		}
	}
	public static boolean validar(String email)
    {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

}
