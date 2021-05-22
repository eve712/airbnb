package com.example.airbnb.dao;

import com.example.airbnb.dto.ReservationDTO;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationDAO {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ReservationDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Long reservationRoom(Long roomId, LocalDate checkIn, LocalDate checkOut, int guestCount, int totalPrice) {
        String sql = "INSERT INTO reservation (room, check_in, check_out, total_price, number_of_guest)" +
                "VALUES (:room, :check_in, :check_out, :total_price, :number_of_guest)";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("room", roomId)
                .addValue("check_in", checkIn)
                .addValue("check_out", checkOut)
                .addValue("total_price", totalPrice)
                .addValue("number_of_guest", guestCount);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, sqlParameterSource, keyHolder, new String[]{"ID"});
        return keyHolder.getKey().longValue();
    }

    public Optional<ReservationDTO> getReservationByReservationId(Long reservationId) {
        String sql = "SELECT r.room, r.check_in, r.check_out, r.total_price, r.number_of_guest FROM reservation r WHERE r.id = :reservation_id";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("reservation_id", reservationId);

        List<ReservationDTO> reservationDTO = namedParameterJdbcTemplate.query(sql, sqlParameterSource, (rs, rowNum) -> {
            return new ReservationDTO(
                    reservationId,
                    rs.getLong("room"),
                    rs.getDate("check_in").toLocalDate(),
                    rs.getDate("check_out").toLocalDate(),
                    rs.getInt("total_price"),
                    rs.getInt("number_of_guest")
            );
        });
        return Optional.ofNullable(DataAccessUtils.singleResult(reservationDTO));
    }

    public void cancelReservationById(Long reservationId) {
        String sql = "DELETE r FROM reservation r WHERE r.id=:reservation_id";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("reservation_id", reservationId);
        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

}












