package conexao;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WSConnection {

	public static JSONObject fromUrl(String cep) throws IOException{
		JSONObject object = null;
		URL request = new URL("http://viacep.com.br/ws/"+ cep +"/json");
		URLConnection conn = request.openConnection();
		conn.setRequestProperty("Accept-Charset", "UTF-8");
		conn.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
		InputStream in = conn.getInputStream();

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
			StringBuilder response = new StringBuilder();
			String input;
			while((input = reader.readLine()) != null){ response.append(input); }
			return new JSONObject(response.toString());
		}
		catch (Exception e) { e.printStackTrace(); }
		return object;
	}

}
