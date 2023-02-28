package iti.jets.repo.daoImplementation;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import iti.jets.repo.daoInterfaces.AddressDao;
import iti.jets.repo.entities.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class AddressDaoImpl implements AddressDao{

	@PersistenceContext
    private EntityManager entityManager ;

    @Override
    @Transactional
    public void save(Address address) {
        entityManager.persist(address);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Address address = entityManager.find( Address.class, id);
        entityManager.remove(address);
    }

    @Transactional
    @Override
    public void update(Address address) {
        entityManager.merge(address);
    }

    @Override
    public Address selectAddress(int id) {
        Address address = entityManager.find(Address.class, id);
        return address;
    }

    @Override
    public List<Address> selectAddresses() {
       TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a", Address.class);
       List<Address> addresses = query.getResultList();
       return addresses;
        
    };
}