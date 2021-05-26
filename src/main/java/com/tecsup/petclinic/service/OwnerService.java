package com.tecsup.petclinic.service;

import java.util.List;

import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

public interface OwnerService {
	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner createOwner(Owner owner);
	
	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner updateOwner(Owner owner);
	
	/**
	 * 
	 * @param id
	 * @throws PetNotFoundException
	 */
	void deleteOwner(long id) throws OwnerNotFoundException;
	
	/**
	 * 
	 * @param id
	 * @throws PetNotFoundException
	 */
	Owner findById(long id) throws OwnerNotFoundException;
	
	/**
	 * 
	 * @param lastName
	 * @return
	 */
	List<Owner> findByLastName(String lastName);
	
	/**
	 * 
	 * @param telephone
	 * @return
	 */
	List<Owner> findByTelephone(String telephone);
	
	
	/**
	 * 
	 * @param address
	 * @return
	 */
	List<Owner> findByAddress(String address);
	
	/**
	 * 
	 * @return
	 */
	Iterable<Owner> findAll();
}
