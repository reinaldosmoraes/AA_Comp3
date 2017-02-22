package roteiroTransacao;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import persistencia.UsuarioMD;
import entidades.Usuario;

public class CriarUsuarioRT {

	public void tratar(String nome, String email, String telefone, Integer motorista, HttpServletResponse response) throws IOException{
		
		//validação
		if(validar(email)){
		
		//validação de telefone
		if(telefone == null){
			response.sendRedirect("erro.jsp");
		}
		
		else{
			//Criação do objeto
			Usuario usuario = new Usuario(nome, email, telefone, motorista);
			
			try{
				
				UsuarioMD usuarioMD = new UsuarioMD();
				usuarioMD.adiciona(usuario);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("index.jsp");
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
