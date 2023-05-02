package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet5")
public class Servlet5 extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public class Client{
		int code;
		String surname;
		String name;
		String patronymic;
		int passportSeries;
		int passportID;
		public Client(int c, String s, String n, String p, int p1, int p2){
			code = c;
			surname = s;
			name = n;
			patronymic = p;
			passportSeries = p1;
			passportID = p2;
		}
	}

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

	ArrayList<Client> clients = new ArrayList<Client>();
	ArrayList<Automobile> automobiles = new ArrayList<Automobile>();
	ArrayList<Rent> rent = new ArrayList<Rent>();
	Client client1 = new Client(1,"Новиков", "Константин","Артемович",4959,327001);
	Client client2 = new Client(2,"Волкова","Ксения","Матвеевна",4322,135392); 
	Client client3 = new Client(3,"Рыбакова","Алина","Сергеевна",4365,867698); 
	Client client4 = new Client(4,"Сидоров","Данил","Владимирович",1906,506387); 
	Client client5 = new Client(5,"Сергеева","Анна","Михайловна",2400,342456); 
	Client client6 = new Client(6,"Семенов","Максим","Григорьевич",8716,785756);
	Client client7 = new Client(7,"Скворцов","Егор","Петрович",1515,632977); 
	Client client8 = new Client(8,"Бирюкова","Лидия","Максимовна",1014,113552); 
	Client client9 = new Client(9,"Зайцев","Матвей","Егорович",1101,193480); 
	Client client10 = new Client(10,"Федорова","Полина","Петровна",5820,113210);
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
	public void init(ServletConfig config) throws ServletException {
		clients.add(client1);
		clients.add(client2);
		clients.add(client3);
		clients.add(client4);
		clients.add(client5);
		clients.add(client6);
		clients.add(client7);
		clients.add(client8);
		clients.add(client9);
		clients.add(client10);
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String betweens = request.getParameter("between");
		String ands = request.getParameter("and");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate between = LocalDate.parse(betweens,formatter);
		LocalDate and = LocalDate.parse(ands,formatter);
		LocalDate date;
		for(int i = 0; i < clients.size(); i++)
			for(int j = 0; j < automobiles.size(); j++)
				for(int k = 0; k < rent.size(); k++){
					date = (rent.get(k)).startDate;
					if((clients.get(i)).code == (automobiles.get(j)).code && (clients.get(i)).code == (rent.get(k)).code) 
						if(date.isBefore(between) == false && date.isAfter(and) == false ){
							out.println((clients.get(i)).surname + " " + (clients.get(i)).name + " ");
							out.println((clients.get(i)).patronymic + " " + (automobiles.get(j)).model + " " + (automobiles.get(j)).number);
							out.println(" дата начала проката: " + (rent.get(k)).startDate + "<br>");
						}
				}
	}
}
