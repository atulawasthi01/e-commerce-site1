package com.niit.shoppingbackend.repository;

import java.util.List;

import com.niit.shoppingbackend.model.Supplier;

public interface SupplierRepository {

	boolean addSupplier(Supplier supplier);
	boolean updateSupplier(Supplier supplier);
	List<Supplier> getAllSuppliers();
	boolean deleteSupplier(int supplierId);
	Supplier getSupplierById(int supplierId);
}

