package maxxton.assignment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;

public class DateMerger {

	/**
	 * @param dateRanges List of sorted date ranges
	 * @return List of merged date ranges
	 */
	public List<DateRange> mergeDates(List<DateRange> dateRanges){

		List<DateRange> resDateRanges =  new ArrayList<>();
		ListIterator<DateRange> itr = dateRanges.listIterator();
		while(itr.hasNext()) {

			DateRange updateRange = new DateRange();

			//Add the first element to the list
			DateRange current = itr.next();
			if (resDateRanges.size() == 0)
				resDateRanges.add(current);

			if (itr.hasNext() &&
				current.compareTo(dateRanges.get(itr.nextIndex())) != 0 &&
				dateRanges.get(itr.nextIndex()).getEndDate().compareTo(current.getStartDate()) > 0 &&
				dateRanges.get(itr.nextIndex()).getStartDate().compareTo(current.getEndDate()) < 0) {

				updateRange.setStartDate(current.getStartDate());
				updateRange.setEndDate(dateRanges.get(itr.nextIndex()).getEndDate());

				if (resDateRanges.get(resDateRanges.size() - 1).getStartDate().equals(current.getStartDate())) {
					resDateRanges.remove(resDateRanges.size() - 1);
					itr.next();
				}
				else {
					updateRange = current;
				}
			}
			else {
				updateRange = current;
			}

			if(!resDateRanges.contains(updateRange))
				resDateRanges.add(updateRange);
		}

		return resDateRanges;
	}

	public static void main(String[] args) throws ParseException{

		DateFormat format = new SimpleDateFormat("dd MMM yyyy");

		List<DateRange> dateRanges =  new ArrayList<>();

		DateMerger dm = new DateMerger();

		dateRanges.add(new DateRange()
			.startDate(format.parse("01 Jan 2014"))
			.endDate(format.parse("30 Jan 2014"))
		);

		dateRanges.add(new DateRange()
			.startDate(format.parse("15 Jan 2014"))
			.endDate(format.parse("15 Feb 2014"))
		);

		dateRanges.add(new DateRange()
			.startDate(format.parse("10 Mar 2014"))
			.endDate(format.parse("15 Apr 2014"))
		);

		dateRanges.add(new DateRange()
			.startDate(format.parse("14 May 2014"))
			.endDate(format.parse("30 May 2014"))
		);

		System.out.println("First Set:");
		System.out.println("input dates");
		System.out.println(dateRanges);
		System.out.println("output dates");
		System.out.println(dm.mergeDates(dateRanges));

		dateRanges = new ArrayList<>();

		dateRanges.add(new DateRange()
			.startDate(format.parse("01 Jan 2014"))
			.endDate(format.parse("15 Jan 2014"))
		);

		dateRanges.add(new DateRange()
			.startDate(format.parse("16 Jan 2014"))
			.endDate(format.parse("30 Jan 2014"))
		);

		System.out.println("Second Set:");
		System.out.println("input dates ");
		System.out.println(dateRanges); System.out.println("output dates ");
		System.out.println(dm.mergeDates(dateRanges));

	  dateRanges = new ArrayList<>();

	  dateRanges.add(new DateRange()
		  .startDate(format.parse("01 Jan 2014"))
		  .endDate(format.parse("15 Jan 2014"))
	  );

	  dateRanges.add(new DateRange()
		.startDate(format.parse("01 Jan 2014"))
		.endDate(format.parse("15 Jan 2014"))
	  );

	  dateRanges.add(new DateRange()
		  .startDate(format.parse("15 Jan 2014"))
		  .endDate(format.parse("30 Jan 2014"))
	  );

	  System.out.println("Third Set:");
	  System.out.println("input dates ");
	  System.out.println(dateRanges);
	  System.out.println("output dates ");
	  System.out.println(dm.mergeDates(dateRanges));
		 
	}
}
