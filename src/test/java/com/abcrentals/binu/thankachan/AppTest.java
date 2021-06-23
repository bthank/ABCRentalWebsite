package com.abcrentals.binu.thankachan;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.abcrentals.binu.thankachan.config.DemoAppConfig;
import com.abcrentals.binu.thankachan.dao.RentalPaymentDao;
import com.abcrentals.binu.thankachan.entity.RentalPayment;
import com.abcrentals.binu.thankachan.service.RentalPaymentService;
import com.abcrentals.binu.thankachan.service.RentalPaymentServiceImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DemoAppConfig.class})
@Transactional
public class AppTest 
    extends TestCase
{
	
 
	private RentalPaymentDao repo;
    private RentalPaymentService service;
    
	
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

     
    
	@Before
	public void setUp() throws Exception {
		repo = Mockito.mock(RentalPaymentDao.class);
		service = new RentalPaymentServiceImpl(repo);
	}
	
	public void testRentalPaymentFindById() {
		RentalPayment expected = new RentalPayment(17L,4L,31,"2023","01", false, null,2400.0, "Early bill");
		expected.setId(1L);
		Mockito.when(repo.findById(anyLong())).thenReturn(expected);
		RentalPayment actual = service.findById(1L);
		assertEquals(expected, actual);
	}
	
    public void testRentalPaymentFindAllRentalPaymentsByRenterUserId()
    {
    	// List<RentalPayment> findAllRentalPaymentsByRenterUserId(long renterUserId);
    	RentalPayment rentalPayment1 = new RentalPayment(17L,4L,31,"2023","01", false, null,2400.0, "Early bill");
    	rentalPayment1.setId(1L);
    	RentalPayment rentalPayment2 = new RentalPayment(17L,3L,31,"2023","01", false, null,2100.0, "Early bill");
    	rentalPayment1.setId(2L);

    	List<RentalPayment> expectedList = new ArrayList<RentalPayment>();
    	expectedList.add(rentalPayment1);
    	expectedList.add(rentalPayment2);
    	Mockito.when(repo.findAllRentalPaymentsByRenterUserId(anyLong())).thenReturn(expectedList);
    	List<RentalPayment> actualList = service.findAllRentalPaymentsByRenterUserId(1L);
    	assertEquals(expectedList,actualList);
    	
    }
	
    public void testRentalPaymentFindAllRentalPaymentsByRentalPropertyIdAndRentalUnitNo()
    {
    	// List<RentalPayment> findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNo(long rentalPropertyId, int rentalUnitNo);
    	RentalPayment rentalPayment1 = new RentalPayment(17L,4L,31,"2023","01", false, null,2400.0, "Early bill");
    	rentalPayment1.setId(1L);
    	RentalPayment rentalPayment2 = new RentalPayment(17L,4L,31,"2024","01", false, null,2100.0, "Early bill");
    	rentalPayment1.setId(2L);

    	List<RentalPayment> expectedList = new ArrayList<RentalPayment>();
    	expectedList.add(rentalPayment1);
    	expectedList.add(rentalPayment2);
    	Mockito.when(repo.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNo(anyLong(),anyInt())).thenReturn(expectedList);
    	List<RentalPayment> actualList = service.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNo(4L,31);
    	assertEquals(expectedList,actualList);
    }
	
    public void testRentalPaymentFindAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonth()
    {
    	// List<RentalPayment> findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonth(long rentalPropertyId, int rentalUnitNo, String year, String month);
    	RentalPayment rentalPayment1 = new RentalPayment(17L,4L,31,"2024","01", false, null,2400.0, "Early bill");
    	rentalPayment1.setId(1L);
    	RentalPayment rentalPayment2 = new RentalPayment(17L,4L,31,"2024","01", false, null,2100.0, "Early bill");
    	rentalPayment1.setId(2L);

    	List<RentalPayment> expectedList = new ArrayList<RentalPayment>();
    	expectedList.add(rentalPayment1);
    	expectedList.add(rentalPayment2);
    	Mockito.when(repo.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonth(anyLong(),anyInt(),anyString(),anyString())).thenReturn(expectedList);
    	List<RentalPayment> actualList = service.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonth(4L,31,"2024","01");
    	assertEquals(expectedList,actualList);
    }
	
    public void testRentalPaymentFindAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYear()
    {
    	// List<RentalPayment> findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYear(long rentalPropertyId, int rentalUnitNo, String year);
    	RentalPayment rentalPayment1 = new RentalPayment(17L,4L,31,"2024","01", false, null,2400.0, "Early bill");
    	rentalPayment1.setId(1L);
    	RentalPayment rentalPayment2 = new RentalPayment(17L,4L,31,"2024","01", false, null,2100.0, "Early bill");
    	rentalPayment1.setId(2L);

    	List<RentalPayment> expectedList = new ArrayList<RentalPayment>();
    	expectedList.add(rentalPayment1);
    	expectedList.add(rentalPayment2);
    	Mockito.when(repo.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYear(anyLong(),anyInt(),anyString())).thenReturn(expectedList);
    	List<RentalPayment> actualList = service.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYear(4L,31,"2024");
    	assertEquals(expectedList,actualList);
    }

    public void testRentalPaymentFindAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonthAndRenterUserId()
    {
    	//  List<RentalPayment> findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonthAndRenterUserId(long rentalPropertyId, 
		//                                                                                                           int rentalUnitNo, String year, String month, long renterUserId);
    	
    	RentalPayment rentalPayment1 = new RentalPayment(17L,4L,31,"2024","01", false, null,2400.0, "Early bill");
    	rentalPayment1.setId(1L);
    	RentalPayment rentalPayment2 = new RentalPayment(17L,4L,31,"2024","01", false, null,2100.0, "Early bill");
    	rentalPayment1.setId(2L);

    	List<RentalPayment> expectedList = new ArrayList<RentalPayment>();
    	expectedList.add(rentalPayment1);
    	expectedList.add(rentalPayment2);
    	Mockito.when(repo.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonthAndRenterUserId(anyLong(),anyInt(),anyString(),anyString(),anyLong())).thenReturn(expectedList);
    	List<RentalPayment> actualList = service.findAllRentalPaymentsByRentalPropertyIdAndRentalUnitNoAndYearAndMonthAndRenterUserId(4L,31,"2024","01",17L);
    	assertEquals(expectedList,actualList);
    }
	
    public void testRentalPaymentFindAllRentalPaymentsByYearAndMonthAndRenterUserId()
    {
       	//  List<RentalPayment> findAllRentalPaymentsByYearAndMonthAndRenterUserId(String year, String month, long renterUserId);     		 
        	
        	RentalPayment rentalPayment1 = new RentalPayment(17L,4L,31,"2024","01", false, null,2400.0, "Early bill");
        	rentalPayment1.setId(1L);
        	RentalPayment rentalPayment2 = new RentalPayment(17L,4L,31,"2024","01", false, null,2100.0, "Early bill");
        	rentalPayment1.setId(2L);

        	List<RentalPayment> expectedList = new ArrayList<RentalPayment>();
        	expectedList.add(rentalPayment1);
        	expectedList.add(rentalPayment2);
        	Mockito.when(repo.findAllRentalPaymentsByYearAndMonthAndRenterUserId(anyString(),anyString(),anyLong())).thenReturn(expectedList);
        	List<RentalPayment> actualList = service.findAllRentalPaymentsByYearAndMonthAndRenterUserId("2024","01",17L);
        	assertEquals(expectedList,actualList);
        
    }

    public void testRentalPaymentFindAllRentalPaymentsByYearAndMonth()
    {
       	//  List<RentalPayment> findAllRentalPaymentsByYearAndMonth(String year, String month);     		 
    	
    	RentalPayment rentalPayment1 = new RentalPayment(17L,4L,31,"2024","01", false, null,2400.0, "Early bill");
    	rentalPayment1.setId(1L);
    	RentalPayment rentalPayment2 = new RentalPayment(17L,4L,31,"2024","01", false, null,2100.0, "Early bill");
    	rentalPayment1.setId(2L);

    	List<RentalPayment> expectedList = new ArrayList<RentalPayment>();
    	expectedList.add(rentalPayment1);
    	expectedList.add(rentalPayment2);
    	Mockito.when(repo.findAllRentalPaymentsByYearAndMonth(anyString(),anyString())).thenReturn(expectedList);
    	List<RentalPayment> actualList = service.findAllRentalPaymentsByYearAndMonth("2024","01");
    	assertEquals(expectedList,actualList);
        }
	
    public void testRentalPaymentFindAllRentalPaymentsByMonthAndRenterUserId()
    {
       	//  List<RentalPayment> findAllRentalPaymentsByMonthAndRenterUserId(String month, long renterUserId);  		 
    	
    	RentalPayment rentalPayment1 = new RentalPayment(17L,4L,31,"2024","01", false, null,2400.0, "Early bill");
    	rentalPayment1.setId(1L);
    	RentalPayment rentalPayment2 = new RentalPayment(17L,4L,31,"2024","01", false, null,2100.0, "Early bill");
    	rentalPayment1.setId(2L);

    	List<RentalPayment> expectedList = new ArrayList<RentalPayment>();
    	expectedList.add(rentalPayment1);
    	expectedList.add(rentalPayment2);
    	Mockito.when(repo.findAllRentalPaymentsByMonthAndRenterUserId(anyString(),anyLong())).thenReturn(expectedList);
    	List<RentalPayment> actualList = service.findAllRentalPaymentsByMonthAndRenterUserId("01",17L);
    	assertEquals(expectedList,actualList);
    }
	
    public void testRentalPaymentFindAllRentalPaymentsByYear()
    {
       	//  List<RentalPayment> findAllRentalPaymentsByYear(String year);
    	
    	RentalPayment rentalPayment1 = new RentalPayment(17L,4L,31,"2024","01", false, null,2400.0, "Early bill");
    	rentalPayment1.setId(1L);
    	RentalPayment rentalPayment2 = new RentalPayment(17L,4L,31,"2024","01", false, null,2100.0, "Early bill");
    	rentalPayment1.setId(2L);

    	List<RentalPayment> expectedList = new ArrayList<RentalPayment>();
    	expectedList.add(rentalPayment1);
    	expectedList.add(rentalPayment2);
    	Mockito.when(repo.findAllRentalPaymentsByYear(anyString())).thenReturn(expectedList);
    	List<RentalPayment> actualList = service.findAllRentalPaymentsByYear("2024");
    	assertEquals(expectedList,actualList); 
    
    }    
	
    public void testRentalPaymentFindAllRentalPaymentsByMonth()
    {
      	//  List<RentalPayment> findAllRentalPaymentsByMonth(String month);
    	
    	RentalPayment rentalPayment1 = new RentalPayment(17L,4L,31,"2024","01", false, null,2400.0, "Early bill");
    	rentalPayment1.setId(1L);
    	RentalPayment rentalPayment2 = new RentalPayment(17L,4L,31,"2024","01", false, null,2100.0, "Early bill");
    	rentalPayment1.setId(2L);

    	List<RentalPayment> expectedList = new ArrayList<RentalPayment>();
    	expectedList.add(rentalPayment1);
    	expectedList.add(rentalPayment2);
    	Mockito.when(repo.findAllRentalPaymentsByMonth(anyString())).thenReturn(expectedList);
    	List<RentalPayment> actualList = service.findAllRentalPaymentsByMonth("01");
    	assertEquals(expectedList,actualList); 
    
    }
	
    public void testRentalPaymentFindAllRentalPaymentsByRentalUnitNo()
    {
      	//  List<RentalPayment> findAllRentalPaymentsByRentalUnitNo(int rentalUnitNo);	
    	
    	RentalPayment rentalPayment1 = new RentalPayment(17L,4L,31,"2024","01", false, null,2400.0, "Early bill");
    	rentalPayment1.setId(1L);
    	RentalPayment rentalPayment2 = new RentalPayment(17L,4L,31,"2024","01", false, null,2100.0, "Early bill");
    	rentalPayment1.setId(2L);

    	List<RentalPayment> expectedList = new ArrayList<RentalPayment>();
    	expectedList.add(rentalPayment1);
    	expectedList.add(rentalPayment2);
    	Mockito.when(repo.findAllRentalPaymentsByRentalUnitNo(anyInt())).thenReturn(expectedList);
    	List<RentalPayment> actualList = service.findAllRentalPaymentsByRentalUnitNo(31);
    	assertEquals(expectedList,actualList); 
        }       
	
    public void testRentalPaymentFindAllRentalPaymentsByRentalPropertyId()
    {
     	//  List<RentalPayment> findAllRentalPaymentsByRentalPropertyId(long rentalPropertyId);
    	
    	RentalPayment rentalPayment1 = new RentalPayment(17L,4L,31,"2024","01", false, null,2400.0, "Early bill");
    	rentalPayment1.setId(1L);
    	RentalPayment rentalPayment2 = new RentalPayment(17L,4L,31,"2024","01", false, null,2100.0, "Early bill");
    	rentalPayment1.setId(2L);

    	List<RentalPayment> expectedList = new ArrayList<RentalPayment>();
    	expectedList.add(rentalPayment1);
    	expectedList.add(rentalPayment2);
    	Mockito.when(repo.findAllRentalPaymentsByRentalPropertyId(anyLong())).thenReturn(expectedList);
    	List<RentalPayment> actualList = service.findAllRentalPaymentsByRentalPropertyId(17L);
    	assertEquals(expectedList,actualList);
    
    }
	
    public void testRentalPaymentFindAllRentalPayments()
    {
     	//  List<RentalPayment> findAllRentalPayments();
    	
    	RentalPayment rentalPayment1 = new RentalPayment(17L,4L,31,"2024","01", false, null,2400.0, "Early bill");
    	rentalPayment1.setId(1L);
    	RentalPayment rentalPayment2 = new RentalPayment(17L,4L,31,"2024","01", false, null,2100.0, "Early bill");
    	rentalPayment1.setId(2L);

    	List<RentalPayment> expectedList = new ArrayList<RentalPayment>();
    	expectedList.add(rentalPayment1);
    	expectedList.add(rentalPayment2);
    	Mockito.when(repo.findAllRentalPayments()).thenReturn(expectedList);
    	List<RentalPayment> actualList = service.findAllRentalPayments();
    	assertEquals(expectedList,actualList);    }       
	
    public void testRentalPaymentSave()
    {
        // void save(RentalPayment rentalPayment);

        RentalPayment rentalPayment = new RentalPayment(17L,4L,31,"2024","01", false, null,2400.0, "Early bill");
        
        service.save(rentalPayment);
         
        verify(repo, times(1)).save(rentalPayment);

     
    }
  
    public void testRentalPaymentDelete()
    {
     
        // given
        final RentalPayment rentalPayment = new RentalPayment(17L,4L,31,"2024","01", false, null,2400.0, "Early bill");
        rentalPayment.setId(1L);

        when(repo.findById(1L))
                .thenReturn(rentalPayment);

        // when
        service.delete(repo.findById(1L));

        // then
        verify(repo, times(1))
                .delete(rentalPayment);
        
     
    }
    
}
