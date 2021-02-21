package business;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;


@Stateless
@Local(SearchBusinessInterface.class)
@LocalBean
public class SearchBusinessService implements SearchBusinessInterface{

	public String findVerse(String link) {
		 try {
			 	String output = "";
			 	String add = "";
	            URL url = new URL(link);//your url i.e fetch data from .
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("Accept", "application/json");
	            if (conn.getResponseCode() != 200) {
	                throw new RuntimeException("Failed : HTTP Error code : "
	                        + conn.getResponseCode());
	            }
	            InputStreamReader in = new InputStreamReader(conn.getInputStream());
	            BufferedReader br = new BufferedReader(in);
	            System.out.println(link);
	            while ((output = br.readLine()) != null) {
	                output += output;
	                add += output;
	            }
	            conn.disconnect();
	            return add;

	        } catch (Exception e) {
	            System.out.println("Exception in NetClientGet:- " + e);
	            return null;
	        }
	}
	
}
