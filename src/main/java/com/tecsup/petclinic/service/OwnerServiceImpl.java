package com.tecsup.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.domain.OwnerRepository;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

@Service
public class OwnerServiceImpl implements OwnerService{
	
	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceImpl.class);
	
	@Autowired
	OwnerRepository ownerRepository;
	
	/**
	 * 
	 * @param owner
	 * @return
	 */
	@Override
	public Owner createOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	/**
	 * 
	 * @param owner
	 * @return
	 */
	@Override
	public Owner updateOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	/**
	 * 
	 * @param id
	 * @throws OwnerNotFoundException
	 */
	@Override
	public void deleteOwner(long id) throws OwnerNotFoundException {
		Owner owner = findById(id);
		ownerRepository.delete(owner);

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Owner findById(long id) throws OwnerNotFoundException {
		Optional <Owner> owner=ownerRepository.findById(id);
		if (!owner.isPresent())
			throw new OwnerNotFoundException("Mascota no encontrada...!");
		return owner.get();
	}

	/**
	 * 
	 * @param lastName
	 * @return
	 */
	@Override
	public List<Owner> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param telephone
	 * @return
	 */
	@Override
	public List<Owner> findByTelephone(String telephone) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param address
	 * @return
	 */
	@Override
	public List<Owner> findByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public Iterable<Owner> findAll() {
		return ownerRepository.findAll();
	}

}
