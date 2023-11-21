package com.ticket_booking;

import com.ticket_booking.extras.LoggedInId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TicketBookingApplicationTests {

	@Autowired
	LoggedInId loggedInId;
	@Test
	void contextLoads() {
		assertNotNull(loggedInId,"This bean will not be null");
	}

}
