package com.live_glow.dao;

import java.sql.SQLException;
import java.util.List;

import com.live_glow.model.Supplier;

public interface ISupplier<T> {
	List <T> findAll()throws SQLException, ClassNotFoundException;
	T findOneById (int id) throws SQLException, ClassNotFoundException ;
	T findOneByName (String name) throws SQLException, ClassNotFoundException;
	T findOneByCompany (String company_name)throws SQLException, ClassNotFoundException;
	T findOneByEmail (String email)throws SQLException, ClassNotFoundException;
	T addSupplier(T object) throws SQLException, ClassNotFoundException;
	
}