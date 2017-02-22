package roteiroTransacao;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;


import persistencia.ParadaMD;
import persistencia.UsuarioMD;

public class InserirUsuarioCaronaRT {
	public void tratar(String email, int id, HttpServletResponse response) throws IOException{
		//validação
		if(validar(email)){
		
		try {
			UsuarioMD md = new UsuarioMD();
			 int i = md.encontraUsuario(email);
			 ParadaMD gmd = new ParadaMD();
			 gmd.usuarioParada(i, id);
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("CrListarCarona");
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
