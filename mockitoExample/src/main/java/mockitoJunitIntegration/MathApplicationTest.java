package mockitoJunitIntegration;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {
	@InjectMocks
	MathApplication mathApplication=new MathApplication();
	
	@Mock
	CalculatorService calculatorService;
	
	@Test
	public void testAdd() {
		when(calculatorService.add(20.00,  30.00)).thenReturn(50.00);
		Assert.assertEquals(mathApplication.add(20.00, 30.00), 50.00);
	}
   
}
