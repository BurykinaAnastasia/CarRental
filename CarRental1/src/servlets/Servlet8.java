package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet8")
public class Servlet8 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public class Automobile{
		int code;
		String model;
		String color;
		int year;
		String number;
		int insuranceCost;
	    int dayCost;
		public Automobile(int c, String m, String c1, int y, String n, int i, int d){
			this.code = c;
			this.model = m;
			this.color = c1;
			this.year = y;
			this.number = n;
			this.insuranceCost = i;
		    this.dayCost = d;
		}		

		public int getPrice(){
			return dayCost;
		}		
		public int getYear(){
			return year;
		}
	}
	
	List<Automobile> automobiles = new ArrayList<Automobile>();
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
	Automobile auto1 = new Automobile(1,"hondaFit","серый",2006,"А655ВТ",9500,500);
	Automobile auto2 = new Automobile(2,"toyotaCamry","черный",2012,"С162ВМ",12000,800);
	Automobile auto3 = new Automobile(3,"toyotaCorolla", "белый", 2011, "Н824ХС", 9000,1000);
	Automobile auto4 = new Automobile(4,"toyotaCamry", "белый", 2013, "Н828ХС", 9000,700);
	Automobile auto5 = new Automobile(5,"toyotaCorolla","белый",2011,"С62НР",15000,1100);
	Automobile auto6 = new Automobile(6,"toyotaCorolla","серый",2011,"В613МС",9000,1200);
	Automobile auto7 = new Automobile(7,"hondaFit","черный",2013,"О002МТ",5700,1000);
	Automobile auto8 = new Automobile(8,"toyotaCamry","серый",2013,"М240ВХ",15000,700);
	Automobile auto9 = new Automobile(9,"mercedes","белый",2012,"Н913ВТ",20000,4500);
	Automobile auto10 = new Automobile(10,"lada2114","белый",2006,"В478РХ",5930,700);
	Supplier< Stream<Automobile>> autoStream = () -> Stream.of(auto1,auto2,auto3,auto4,auto5,auto6,auto7,auto8,auto9,auto10);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Map<Integer, Optional<Automobile>> price1 = autoStream.get().collect(
				Collectors.groupingBy(Automobile::getYear,
				Collectors.minBy(Comparator.comparing(Automobile::getPrice))));
		Map<Integer, Optional<Automobile>> price2 = autoStream.get().collect(
				Collectors.groupingBy(Automobile::getYear,
				Collectors.maxBy(Comparator.comparing(Automobile::getPrice))));
		out.println("минимальная стоимость" + "<br>");
		for(Map.Entry<Integer, Optional<Automobile>> item1 : price1.entrySet()){
			out.println(item1.getKey() + " - " + item1.getValue().get().getPrice() + "<br>");
			continue;
		}
		out.println("максимальная стоимость" + "<br>");
		for(Map.Entry<Integer, Optional<Automobile>> item2 : price2.entrySet()){
			out.println(item2.getKey() + " - " + item2.getValue().get().getPrice() + "<br>");
			continue;
		}
		 
	}
}
