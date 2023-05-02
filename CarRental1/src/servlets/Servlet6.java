package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.time.LocalDate;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet6")
public class Servlet6 extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	public class Automobile{
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
		public String showText(){
			return (" дата начала проката: " + startDate + " стоимость одного дня проката: " + dayCost + " количество дней проката: " + amountOfDays);
		}
	}

	ArrayList<Automobile> automobiles = new ArrayList<Automobile>();
	ArrayList<Rent> rent = new ArrayList<Rent>();
	Automobile auto1 = new Automobile(1,"hondaFit","серый",2003,"А655ВТ",9500);
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
	Rent rent4 = new Rent(4,100,date4,7);
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		for(int i = 0; i < automobiles.size(); i++)
			for(int j = 0; j < rent.size(); j++){
				if((automobiles.get(i)).code == (rent.get(j)).code) {
					out.println((automobiles.get(i)).number + " " + (automobiles.get(i)).model + (rent.get(j)).showText());
					out.println(" стоимость проката: " + (rent.get(j)).dayCost*(rent.get(j)).amountOfDays + "<br>");
				}
			}
	}
}
