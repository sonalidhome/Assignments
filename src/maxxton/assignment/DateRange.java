package maxxton.assignment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DateRange implements Comparable {
	
	private Date startDate;
	private Date endDate;


	public DateRange startDate(Date startDate){
		this.startDate = startDate;
		return this;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public DateRange endDate(Date endDate){
		this.endDate = endDate;
		return this;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		DateFormat format = new SimpleDateFormat("dd MMM yyyy");
		return "\n" + format.format(startDate)+ " - " + format.format(endDate) ;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DateRange dateRange = (DateRange) o;
		return Objects.equals(startDate, dateRange.startDate) &&
			Objects.equals(endDate, dateRange.endDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(startDate, endDate);
	}

	@Override
	public int compareTo(Object o) {
		DateRange that = (DateRange) o;
		if(this.getStartDate().compareTo(that.getStartDate()) > 0
			&& this.getEndDate().compareTo(that.getEndDate()) > 0)
			return 1;
		if(this.getStartDate().compareTo(that.getStartDate()) == 0
			&& this.getEndDate().compareTo(that.getEndDate()) == 0)
			return 0;
		return -1;
	}
}
