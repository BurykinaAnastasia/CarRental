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
@WebServlet("/Servlet1")

public class Servlet1 extends HttpServlet{
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
	Automobile auto1 = new Automobile("lada2110","белый",2005,"А022ВТ",5930);
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
	 		
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 String model1 = request.getParameter("model1"), model2;
		 response.setContentType("text/html;charset=utf-8");
		 PrintWriter out = response.getWriter();
		 int i; 
		 for(i = 0; i < automobiles.size(); i++){ 
			 model2 =(automobiles.get(i)).model; 
			 if(model1.equals(model2)){
				 out.println((automobiles.get(i)).showText()); 
				 break;
			 }
		 } 
		 if(i == automobiles.size())
			 out.println("Нет информации");
	 }
		  
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 response.setContentType("text/html;charset=utf-8");
		 PrintWriter out = response.getWriter();
		 int year1 = Integer.parseInt(request.getParameter("year3")),year2;
		 ArrayList<Automobile> old_automobiles = new ArrayList<Automobile>();
		 int i; 
		 for(i = 0; i < automobiles.size(); i++){ 
			 year2 =(automobiles.get(i)).year; 
			 if(year2 < year1)
				 old_automobiles.add(automobiles.get(i));
		 }
		 for(i = 0; i < old_automobiles.size(); i++) 
			 out.println(old_automobiles.get(i).showText() + "<br>");
	 }	
}