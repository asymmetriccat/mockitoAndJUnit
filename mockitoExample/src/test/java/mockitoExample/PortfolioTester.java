package mockitoExample;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
public class PortfolioTester {
     Portfolio portfolio;
     StockService stockService;
     
     public void setUp() {
    	 portfolio=new Portfolio();
    	 stockService=mock(StockService.class);
    	 portfolio.setStockService(stockService);
    			 
     }
     
     public boolean testMarketValue() {
    	 List<Stock> list=new ArrayList<Stock>();
    	 Stock googleStock =new Stock("1", "Google", 10);
    	 Stock MicroSoft =new Stock("2", "MS", 100);
    	 list.add(googleStock);
    	 list.add(MicroSoft);
    	 portfolio.setStocks(list);
    	 when(stockService.getPrice(googleStock)).thenReturn(50.00);
    	 when(stockService.getPrice(MicroSoft)).thenReturn(1000.00);
    	 double marketValue=portfolio.getMarketValue();
    	 return marketValue==100500.00;
    	 
     }
     
     public static void main(String[] args) {
    	 PortfolioTester tester =new PortfolioTester();
    	 tester.setUp();
    	 System.out.println(tester.testMarketValue()?"pass":"fail");
    	 
     }
}
