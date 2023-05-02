package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public class Automobile{
		String model;
		String color;
		int year;
		String number;
		int insuranceCost;
		public Automobile(String m, String c1, int y, String n, int i){
			model = m;
			color = c1;
			year = y;
			number = n;
			insuranceCost = i;
		}
		public String showText(){
			return (model + " " + color + " " + year + " " + number + " страховая стоимость:" + insuranceCost);
		}
	}
	
	ArrayList<Automobile> automobiles = new ArrayList<Automobile>();
	Automobile auto1 = new Automobile("hondaFit","серый",2003,"А655ВТ",9500);
	Automobile auto2 = new Automobile("fordScorpio","черный",1989,"С452ВМ",10000);
	Automobile auto3 = new Automobile("oka","зеленый",2006,"Р726ТВ",5000);
	Automobile auto4 = new Automobile("toyotaCamry", "белый", 2008, "Н828ХС", 8000);
	Automobile auto5 = new Automobile("fiat125","красный",1970,"С649НР",8500);
	Automobile auto6 = new Automobile("toyotaCorolla","серый",2009,"В613МС",5000);
	Automobile auto7 = new Automobile("hondaFit","черный",2013,"О002МТ",5700);
	Automobile auto8 = new Automobile("subaruForester","серый",2014,"М810ВХ",6200);
	Automobile auto9 = new Automobile("mercedes","белый",2012,"Н913ВТ",20000);
	Automobile auto10 = new Automobile("lada2114","белый",2006,"В478РХ",5930);
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		automobiles.add(auto1);
		automobiles.add(auto2);
		automobiles.add(auto3);
		automobiles.add(auto4);
		automobiles.add(auto5);
		automobiles.add(auto6);
		automobiles.add(auto7);
		automobiles.add(auto8);
		automobiles.add(auto9);
		automobiles.add(auto10);		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String number1 = request.getParameter("number"), number2;
		  response.setContentType("text/html;charset=utf-8");
		  PrintWriter out = response.getWriter();
		  int i; 
		  for(i = 0; i < automobiles.size(); i++){ 
			  if(number1.length() < 6) {
				  out.println("Введите правильный госномер");
				  break;
			  }
			  number2 =(automobiles.get(i)).number; 
			  if(number1.equals(number2)){
				  out.println((automobiles.get(i)).showText()); 
				  break;
			  }
		  } 
		  if(i == automobiles.size())
			  out.println("Нет информации");
	}
}