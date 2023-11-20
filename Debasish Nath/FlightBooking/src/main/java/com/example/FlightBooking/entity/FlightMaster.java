package com.example.FlightBooking.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//
//import java.util.Date;
//
//@Data
//@NoArgsConstructor
//@Entity
//@Table(name = "flight")
//public class FlightMaster {
//
//    @Id
//    @Column(name = "f_no", length = 50, nullable = false)
//    private String flightId;
//
//    @Column(name = "a_id", length = 50)
//    private String airlineId;
//
//    @ManyToOne
//    @JoinColumn(name = "airline_master")
//    private AirlineMaster airlineMaster;
//
//    @Column(name = "tot_seats", nullable = false)
//    private Integer totalSeats;
//
//    @Column(name = "src", nullable = false)
//    private Integer sourceId;
//
//    @ManyToOne
//    @JoinColumn(name = "location_master")
//    private String locationId;
//
//    @Column(name = "dest", nullable = false)
//    private Integer destinationId;
//
//    @ManyToOne
//    @JoinColumn(name = "location_master")
//    private LocationMaster locationId;
//
//    @Column(name = "depart_time", length = 50, nullable = false)
//    private String departureTime;
//
//    @Column(name = "fare", nullable = false)
//    private Double fare;
//
//    @Column(name = "ava_seats", nullable = false)
//    private Integer availableSeats;
//
//    @Column(name = "depart_date", nullable = false)
//    @Temporal(TemporalType.DATE)
//    private Date departureDate;
//
//
//}

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "flight")
@Data
@NoArgsConstructor
public class FlightMaster {

    @Id
    @Column(name = "f_no", length = 50, nullable = false)
    private String flightId;

    @ManyToOne
    @JoinColumn(name = "aid", referencedColumnName = "a_id")
    private AirlineMaster airlineId;

    @Column(name = "tot_seats", nullable = false)
    private Integer totalSeats;

    @ManyToOne
    @JoinColumn(name = "sourceId", referencedColumnName = "location_id")
    private LocationMaster sourceId;

    @ManyToOne
    @JoinColumn(name = "destinationId",referencedColumnName = "location_id")
    private LocationMaster destinationId;

    @Column(name = "depart_time", length = 50, nullable = false)
    private String departureTime;

    @Column(name = "fare", nullable = false)
    private Double fare;

    @Column(name = "ava_seats", nullable = false)
    private Integer availableSeats;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "depart_date", nullable = false)
    private Date departureDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flightId", cascade = CascadeType.ALL)
    private List<BookingInfo> bookingInfos;

}
