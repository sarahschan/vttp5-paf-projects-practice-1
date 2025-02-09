package vttp2023.batch3.assessment.paf.bookings.repositories;

public class SQLQueries {
    
    public static final String GET_OCCUPANCY = 
        """  
            select ao.vacancy as vacancy
            from acc_occupancy ao 
	            where ao.acc_id = ?;
        """;


    public static final String INSERT_RESERVATION = 
        """
            insert into reservations 
	            (resv_id, name, email, acc_id, arrival_date, duration)
            values
	            (?, ?, ?, ?, ?, ?);   
        """;

    
    public static final String UPDATE_AVAILABILITY = 
    """
          update acc_occupancy 
	        set vacancy = ?
	        where acc_id = ?;      
    """;
}
