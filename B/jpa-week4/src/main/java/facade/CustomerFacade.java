package facade;

import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CustomerFacade implements FacadeInterface
{
    EntityManagerFactory emf;
    
    public CustomerFacade()
    {
    }
    
    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    @Override
    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }
    
    @Override
    public Customer createPerson(Customer person)
    {
        EntityManager em = getEntityManager();
        
        try
        {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            return person;
        }
        finally
        {
            em.close();
        }
    }
    
    @Override
    public Customer getPerson(Long id)
    {
        EntityManager em = getEntityManager();
        
        Customer p = null;
        
        try
        {
            em.getTransaction().begin();
            p = em.find(Customer.class, id);
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }
    }
    
    @Override
    public Customer editPerson(Customer person)
    {
        EntityManager em = getEntityManager();
        
        Customer p = null;
        
        try
        {
            em.getTransaction().begin();
            p = em.find(Customer.class, person.getId());
            if(p != null)
            {
                em.merge(p);
            }
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public Customer deletePerson(Customer person)
    {
        EntityManager em = getEntityManager();
        
        Customer p = null;
        
        try
        {
            em.getTransaction().begin();
            p = em.find(Customer.class, person.getId());
            if(p != null)
            {
                em.remove(p);
            }
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }
    }
}