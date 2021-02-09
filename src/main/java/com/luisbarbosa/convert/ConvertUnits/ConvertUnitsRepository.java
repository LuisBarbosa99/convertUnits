package com.luisbarbosa.convert.ConvertUnits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConvertUnitsRepository extends JpaRepository<ConvertUnits,Long> {

}
