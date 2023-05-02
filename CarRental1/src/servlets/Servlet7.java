package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Map;
import java.util.function.Supplier;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.IntSummaryStatistics;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets.Servlet8.Automobile;

@WebServlet("/Servlet7")
public class Servlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public class Automobile {
		int code;
		String model;
		String color;
		int year;
		String number;
		int insuranceCost;
		public Automobile(int c, String m, String c1, int y, String n, int i) {
			code = c;
			model = m;
			color = c1;
			year = y;
			number = n;
			insuranceCost = i;
		}

		
		public String getModel(){
			return model;			
		}
		public int getCost(){
			return insuranceCost;
		}
	}

	List<Automobile> automobiles = new ArrayList<Automobile>();
	Automobile auto1 = new Automobile(1,"hondaFit","�����",2006,"�655��",9500);
	Automobile auto2 = new Automobile(2,"toyotaCamry","������",2012,"�162��",12000);
	Automobile auto3 = new Automobile(3,"toyotaCorolla", "�����", 2011, "�824��", 9000);
	Automobile auto4 = new Automobile(4,"toyotaCamry", "�����", 2013, "�828��", 9000);
	Automobile auto5 = new Automobile(5,"toyotaCorolla","�����",2011,"�62��",15000);
	Automobile auto6 = new Automobile(6,"toyotaCorolla","�����",2011,"�613��",9000);
	Automobile auto7 = new Automobile(7,"hondaFit","������",2013,"�002��",5700);
	Automobile auto8 = new Automobile(8,"toyotaCamry","�����",2013,"�240��",15000);
	Automobile auto9 = new Automobile(9,"mercedes","�����",2012,"�913��",20000);
	Automobile auto10 = new Automobile(10,"lada2114","�����",2006,"�478��",5930);
	Supplier< Stream<Automobile>> autoStream = () -> Stream.of(auto1,auto2,auto3,auto4,auto5,auto6,auto7,auto8,auto9,auto10);
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Map<String, IntSummaryStatistics> cost = autoStream.get().collect(
				Collectors.groupingBy(Automobile::getModel, 
				Collectors.summarizingInt(Automobile::getCost)));
		for(Map.Entry<String, IntSummaryStatistics> item : cost.entrySet())
			out.println(item.getKey() + " - " + item.getValue().getAverage() + "<br>");
	}
}
