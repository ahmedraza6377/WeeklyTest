package com.productManagament.productManagament.Repository;

import com.productManagament.productManagament.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface IUserRepo extends CrudRepository<User,Integer> {
}
