package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public class Automobile {
		int code;
		String model;
		String color;
		int year;
		String number;
		int insuranceCost;
		public Automobile(int c, String m, String c1, int y, String n, int i){
			code = c;
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

	public class Rent{
		int code;
		int dayCost;
		LocalDate startDate;
		int amountOfDays;
		public Rent(int c, int d, LocalDate s, int a){
			code = c;
			dayCost = d;
			startDate = s;
			amountOfDays = a;
		}
	}

	ArrayList<Automobile> automobiles = new ArrayList<Automobile>();
	ArrayList<Rent> rent = new ArrayList<Rent>();
	private ArrayList <Automobile> copy_automobiles;
	Automobile auto1 = new Automobile(1,"lada2110","белый",2005,"А022ВТ",5930);
	Automobile auto2 = new Automobile(2,"fordScorpio","черный",1989,"С452ВМ",10000);
	Automobile auto3 = new Automobile(3,"oka","зеленый",2006,"Р726ТВ",5000);
	Automobile auto4 = new Automobile(4,"toyotaCamry", "белый", 2008, "Н828ХС", 8000);
	Automobile auto5 = new Automobile(5,"fiat125","красный",1970,"С649НР",8500);
	Automobile auto6 = new Automobile(6,"toyotaCorolla","серый",2009,"В613МС",5000);
	Automobile auto7 = new Automobile(7,"hondaFit","черный",2013,"О002МТ",5700);
	Automobile auto8 = new Automobile(8,"subaruForester","серый",2014,"М810ВХ",6200);
	Automobile auto9 = new Automobile(9,"mercedes","белый",2012,"Н913ВТ",20000);
	Automobile auto10 = new Automobile(10,"lada2114","белый",2006,"В478РХ",5930);
	LocalDate date1 = LocalDate.of(2020,6,29);
	LocalDate date2 = LocalDate.of(2020,7,3);
	LocalDate date3 = LocalDate.of(2020,6,29);
	LocalDate date4 = LocalDate.of(2020,6,27);
	LocalDate date5 = LocalDate.of(2020,6,30);
	LocalDate date6 = LocalDate.of(2020,7,2);
	LocalDate date7 = LocalDate.of(2020,7,2);
	LocalDate date8 = LocalDate.of(2020,7,1);
	LocalDate date9 = LocalDate.of(2020,8,1);
	LocalDate date10 = LocalDate.of(2020,5,18);
	Rent rent1 = new Rent(1,500,date1,30);
	Rent rent2 = new Rent(2,800,date2,14);
	Rent rent3 = new Rent(3,500,date3,10);
	Rent rent4 = new Rent(4,1000,date4,7);
	Rent rent5 = new Rent(5,1500,date5,10);
	Rent rent6 = new Rent(6,1200,date6,60);
	Rent rent7 = new Rent(7,1000,date7,30);
	Rent rent8 = new Rent(8,1200,date8,20);
	Rent rent9 = new Rent(9,4500,date9,7);
	Rent rent10 = new Rent(10,700,date10,7);

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
		rent.add(rent1);
		rent.add(rent2);
		rent.add(rent3);
		rent.add(rent4);
		rent.add(rent5);
		rent.add(rent6);
		rent.add(rent7);
		rent.add(rent8);
		rent.add(rent9);
		rent.add(rent10);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int year1 = Integer.parseInt(request.getParameter("year1")),year2;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("Автомобили, изготовленные до 1990 года");
		out.println("<br>");
		for(Automobile auto: automobiles){ 
			year2 = auto.year; 
			if(year1 > year2){
				out.println(auto.showText()); 
				out.println("<br>");
			}
		} 		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if("delete".equals(request.getParameter("action"))){
			doDelete(request,response);
			return;
		}
		if("put".equals(request.getParameter("action"))){
			doPut(request,response);
			return;
		}
		copy_automobiles =(ArrayList) automobiles.clone();
		for(int i = 0; i < copy_automobiles.size(); i++)
			for(int j = 0; j < rent.size(); j++)
				if(copy_automobiles.get(i).code == rent.get(j).code )
					out.println((copy_automobiles.get(i)).showText() + " стоимость одного дня проката: " + rent.get(j).dayCost +  "<br>");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		int value1 = Integer.parseInt(req.getParameter("value")),value2;
		int i;
		for( i = 0; i < copy_automobiles.size(); i++){
			for(int j = 0; j < rent.size(); j++){
				value2 = rent.get(j).dayCost;
				if(copy_automobiles.get(i).code == rent.get(j).code && value2 > value1)
					copy_automobiles.remove(copy_automobiles.get(i));
			}
		}
		for( i = 0; i < copy_automobiles.size(); i++)
			for(int j = 0; j < rent.size(); j++)
				if(copy_automobiles.get(i).code == rent.get(j).code )
					out.println((copy_automobiles.get(i)).showText() + " стоимость одного дня проката: " + rent.get(j).dayCost +  "<br>");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		int year1 = Integer.parseInt(req.getParameter("year4")),year2;
		int i;
		for( i = 0; i < copy_automobiles.size(); i++){
			for(int j = 0; j < rent.size(); j++){
				year2 = copy_automobiles.get(i).year;
				if(copy_automobiles.get(i).code == rent.get(j).code && year2 > year1){
					rent.get(j).dayCost+=rent.get(j).dayCost/100*10;
				}
			}
		}
		for( i = 0; i < copy_automobiles.size(); i++)
			for(int j = 0; j < rent.size(); j++)
				if(copy_automobiles.get(i).code == rent.get(j).code )
					out.println((copy_automobiles.get(i)).showText() + " стоимость одного дня проката: " + rent.get(j).dayCost +  "<br>");
	}
}