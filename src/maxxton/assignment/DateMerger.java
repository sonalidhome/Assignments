package maxxton.assignment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DateMerger {

	/**
	 * @param dateRanges
	 * @return
	 */
	public List<DateRange> mergeDates(List<DateRange>dateRanges){

		List<DateRange> resDateRanges =  new ArrayList<DateRange>();

		DateRange tempDateRange = dateRanges.get(0);
		resDateRanges.add(tempDateRange);
		for (int i = 1; i < dateRanges.size(); i++) {

			DateRange dateRange = dateRanges.get(i);
			DateRange dateRangeTemp = new DateRange();
			if(tempDateRange.getEndDate().compareTo(dateRange.getStartDate())>=0) {
				dateRangeTemp.setStartDate(tempDateRange.getStartDate());
				dateRangeTemp.setEndDate(dateRange.getEndDate());
				if (! resDateRanges.isEmpty() && 
						resDateRanges.get(resDateRanges.size()-1).getStartDate().equals(dateRangeTemp.getStartDate())) {
					resDateRanges.remove(resDateRanges.size()-1);
				}
			}else{
				if(dateRanges.size() > i+1) {
					DateRange dateRange1 = dateRanges.get(i+1);
					if(dateRange.getEndDate().compareTo(dateRange1.getStartDate())>=0) {
						dateRangeTemp.setStartDate(dateRange.getStartDate());
						dateRangeTemp.setEndDate(dateRange1.getEndDate());
					}else {
						dateRangeTemp = dateRange;
					}
				}else {
					dateRangeTemp = dateRange;
				}


			}
			tempDateRange = dateRangeTemp;
			resDateRanges.add(dateRangeTemp);
		}		
		return resDateRanges;

	}

	public static void main(String[] args) {

		DateFormat format = new SimpleDateFormat("dd MMM yyyy");

		List<DateRange>dateRanges =  new ArrayList<DateRange>();
		

		DateMerger dm = new DateMerger();

		DateRange dateRange = null;
		try {
			dateRange = new DateRange(format.parse("01 Jan 2014"),format.parse("30 Jan 2014")); 
			dateRanges.add(dateRange);
			dateRange = null;

			dateRange = new DateRange(format.parse("15 Jan 2014"),format.parse("15 Feb 2014")); 
			dateRanges.add(dateRange);
			dateRange = null;

			dateRange = new DateRange(format.parse("10 Mar 2014"),format.parse("15 Apr 2014")); 
			dateRanges.add(dateRange);
			dateRange = null;

			dateRange = new DateRange(format.parse("16 Apr 2014"),format.parse("15 May 2014")); 
			dateRanges.add(dateRange);
			dateRange = null;


			dateRange = new DateRange(format.parse("14 May 2014"),format.parse("30 May 2014")); 
			dateRanges.add(dateRange);
			dateRange = null;


		} catch (ParseException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} 
		System.out.println("input dates");
		System.out.println(dateRanges); System.out.println("output dates");
		System.out.println(dm.mergeDates(dateRanges));

		dateRanges = null; dateRanges = new ArrayList<DateRange>();



		try { 
			dateRange = new DateRange(format.parse("01 Jan 2014"),format.parse("15 Jan 2014")); 
			dateRanges.add(dateRange);
			dateRange = null;
	
			dateRange = new DateRange(format.parse("16 Jan 2014"),format.parse("30 Jan 2014")); 
			dateRanges.add(dateRange);
			dateRange = null;

		} catch (ParseException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} 
		System.out.println("input dates 2");
		System.out.println(dateRanges); System.out.println("output dates 2 ");
		System.out.println(dm.mergeDates(dateRanges));

	
	  dateRanges = null; 
	  dateRanges = new ArrayList<DateRange>(); 
	  try { 
		  dateRange = new DateRange(format.parse("01 Jan 2014"),format.parse("15 Jan 2014")); 
		  dateRanges.add(dateRange);
		  dateRange = null;
		  
		  dateRange = new DateRange(format.parse("15 Jan 2014"),format.parse("30 Jan 2014")); 
		  dateRanges.add(dateRange);
		  dateRange = null;
		  
	  } catch (ParseException e) { 
		  // TODO Auto-generated catch block
		  e.printStackTrace(); 
	  } 
	  System.out.println("input dates 3");
	  System.out.println(dateRanges); System.out.println("output dates 3 ");
	  System.out.println(dm.mergeDates(dateRanges));
		 
	}
}
