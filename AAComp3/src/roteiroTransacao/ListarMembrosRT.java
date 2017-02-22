package roteiroTransacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Carona;
import entidades.Usuario;
import persistencia.CaronaMD;
import persistencia.GrupoMD;
import persistencia.GrupoUsuarioMD;
import persistencia.UsuarioMD;

public class ListarMembrosRT {
	public void tratarGet(int id, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
			HttpSession sessao = request.getSession();
			String email = sessao.getAttribute("email").toString();
			UsuarioMD md;
			try {
				md = new UsuarioMD();
				int i = md.encontraUsuario(email);
				GrupoUsuarioMD gumd = new GrupoUsuarioMD();
				int reg = gumd.regrasAceitas(i, id);
				
				request.setAttribute("Reg", reg);
				request.setAttribute("Membros", listaGrupo(id));
				request.setAttribute("Caronas", listaCarona(id));
				
				RequestDispatcher rd = request.getRequestDispatcher("frListarUsuariosGrupo.jsp?id=" + id );
				rd.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}
	public List<Usuario> listaGrupo(int id){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		GrupoMD md;
		try {
			md = new GrupoMD();
			usuarios = md.getListaUsuarios(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarios;
		
	}
	public List<Carona> listaCarona(int id){
		List<Carona> caronas = new ArrayList<Carona>();
		CaronaMD md;
		try {
			md = new CaronaMD();
			caronas = md.getListaCaronaGrupo(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return caronas;
		
	}
}
