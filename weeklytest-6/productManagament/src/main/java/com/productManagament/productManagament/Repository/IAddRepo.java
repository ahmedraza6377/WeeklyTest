package com.productManagament.productManagament.Repository;

import com.productManagament.productManagament.Model.Address;
import io.micrometer.observation.Observation;
import org.springframework.data.repository.CrudRepository;

public interface IAddRepo extends CrudRepository<Address,Integer> {
}
