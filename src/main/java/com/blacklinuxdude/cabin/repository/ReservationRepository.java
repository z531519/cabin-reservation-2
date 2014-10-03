package com.blacklinuxdude.cabin.repository;

import com.blacklinuxdude.cabin.model.Employee;
import com.blacklinuxdude.cabin.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

//@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    Iterable<Reservation> findByEmployee(Employee employee);

    Iterable<Reservation> findByDateBetween(Date from, Date to);
}
