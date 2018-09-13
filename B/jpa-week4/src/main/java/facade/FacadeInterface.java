package facade;

import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

interface FacadeInterface
{
    public void addEntityManagerFactory(EntityManagerFactory emf);        
    public EntityManager getEntityManager();
    public Customer createPerson(Customer p);
    public Customer getPerson(Long id);
    public Customer editPerson(Customer p);
    public Customer deletePerson(Customer p);
}
