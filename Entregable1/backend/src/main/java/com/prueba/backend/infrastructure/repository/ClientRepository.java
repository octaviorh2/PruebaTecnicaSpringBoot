package com.prueba.backend.infrastructure.repository;

import com.prueba.backend.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository  extends JpaRepository<Client , Long> {


    @Query( value = """
            SELECT * FROM client c WHERE c.date_record BETWEEN Date(:startDate) AND Date(:endDate)
            """ , nativeQuery = true)
    List<Client> findByDateRecordBetween(String startDate , String  endDate);



}
