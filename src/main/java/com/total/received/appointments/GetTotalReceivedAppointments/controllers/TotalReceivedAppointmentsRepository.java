package com.total.received.appointments.GetTotalReceivedAppointments.controllers;

import com.total.received.appointments.GetTotalReceivedAppointments.model.BookAppointment;
import com.total.received.appointments.GetTotalReceivedAppointments.model.CustomResponse;
import com.total.received.appointments.GetTotalReceivedAppointments.repositories.BookAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigInteger;
import java.util.List;


@RestController
@RequestMapping("/total-received-appointments")
public class TotalReceivedAppointmentsRepository {

    @Autowired
    private BookAppointmentRepository bookAppointmentRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<CustomResponse> getTotalReceivedAppointment(@RequestBody BookAppointment bookAppointment) {
        List<BookAppointment> list = bookAppointmentRepository.findAll();
        int count = 0;
        for (BookAppointment appointment: list) {
            String dataFromTable = appointment.getAppointment_date().getDate()
                    +"-"+appointment.getAppointment_date().getMonth()
                    +"-"+appointment.getAppointment_date().getYear();
            String dataFromRequest = bookAppointment.getAppointment_date().getDate()
                    +"-"+bookAppointment.getAppointment_date().getMonth()
                    +"-"+bookAppointment.getAppointment_date().getYear();
            if (dataFromTable.equalsIgnoreCase(dataFromRequest) && appointment.getDoctor_id().equals(bookAppointment.getDoctor_id())) {
                count++;
            }
        }
        CustomResponse customResponse = new CustomResponse();
        customResponse.setTotalRecResponse(BigInteger.valueOf(count));
        return ResponseEntity.status(HttpStatus.CREATED).body(customResponse);
    }
}
