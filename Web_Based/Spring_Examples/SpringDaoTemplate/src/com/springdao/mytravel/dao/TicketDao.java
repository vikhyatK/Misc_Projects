package com.springdao.mytravel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.springdao.mytravel.model.Ticket;

@Repository
public class TicketDao extends GenericDao {

	private static final String SQL_INSERT_TICKETS = "insert into tickets ( flightNumber, passengerName, time)  values (?, ?, ?)";

	private static final String SQL_GET_TICKET = "select ticketId, flightNumber, passengerName, time from tickets where ticketid = ?";

	private static final String SQL_CANCEL_TICKET = "delete from tickets where ticketid = :ticketId";

	public Ticket getTicket(long ticketId) {
		return jdbcTemplate.queryForObject(SQL_GET_TICKET,
				new ParameterizedRowMapper<Ticket>() {
					public Ticket mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Ticket ticket = new Ticket();
						ticket.setTicketId(rs.getLong(1));
						ticket.setFlightNumber(rs.getString(2));
						ticket.setPassengerName(rs.getString(3));
						ticket.setTime(rs.getDate(4));
						return ticket;
					}
				}, ticketId);
	}

	public void saveTicket(Ticket ticket) {

		jdbcTemplate.update(
				SQL_INSERT_TICKETS,
				new Object[] { ticket.getFlightNumber(),
						ticket.getPassengerName(), new Date() });
		System.out.println("Flight ticket booked!");
	}

	public void cancelTicket(long ticketId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticketId", ticketId);
		namedParameterJdbcTemplate.update(SQL_CANCEL_TICKET, params);
		System.out.println("Flight ticket cancelled!");
	}

}
