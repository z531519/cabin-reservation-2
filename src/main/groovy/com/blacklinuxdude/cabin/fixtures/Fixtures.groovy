package com.blacklinuxdude.cabin.fixtures;

import com.blacklinuxdude.cabin.model.Asset;
import com.blacklinuxdude.cabin.model.Employee
import com.blacklinuxdude.cabin.model.Reservation
import com.blacklinuxdude.cabin.model.ReservationBid
import com.blacklinuxdude.cabin.model.Season;
import com.blacklinuxdude.cabin.repository.AssetRepository
import com.blacklinuxdude.cabin.repository.EmployeeRepository
import org.joda.time.DateTime
import org.joda.time.DateTimeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext;

@Component
public class Fixtures implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    AssetRepository assetRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Asset asset;
        asset = new Asset();
        asset.setId("CAB01");
        asset.setName("Cabin MN");
        assetRepository.save(asset);

        asset = new Asset();
        asset.setId("CONDO01");
        asset.setName("Condo WI");
        assetRepository.save(asset);

        for (Asset a : assetRepository.findAll()) {
            System.out.println(a);
        }

        Employee employee;

        employee = new Employee(id:'kdeleon', name: 'Ken De Leon', hired: new Date());

        employeeRepository.save(employee)
        employeeRepository.save(new Employee(id:'lzurbano', name: 'Linus Zurbano', hired: new Date()))

        employeeRepository.findAll().each {
            println it.id
        }

        Season season = new Season(id:"2014SUMMMER", phase: Season.Phase.SUMMER, assets:assetRepository.findAll().toList(), openSeason: true )

        entityManager.persist(season)

        ReservationBid bid = new ReservationBid(season:season, employee: employee,
                asset: asset, priority: 0, checkinDate: new Date());

        entityManager.persist(bid);

        //create existing reservations

        Reservation reservation
        reservation = new Reservation(employee: employee, asset: asset, date: new Date());
        entityManager.persist(reservation);
        reservation = new Reservation(employee: employee, asset: asset, date: new DateTime().withDayOfWeek(DateTimeConstants.MONDAY).toDate());
        entityManager.persist(reservation);

    }

}
