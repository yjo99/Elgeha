package iti.jets.repo.daoInterfaces;

import java.util.List;

import iti.jets.entities.Address;

public interface AddressDao {
	public void save(Address address);
    public void deleteById(int id);
    public void update(Address address);
    public Address selectAddress(int id);
    public List<Address> selectAddresses();
}
