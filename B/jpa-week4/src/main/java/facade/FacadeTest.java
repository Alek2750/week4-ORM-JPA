package facade;

import entity.Customer;
import javax.persistence.Persistence;

public class FacadeTest
{
    public static void main(String[] args)
    {
        CustomerFacade facade = new CustomerFacade();
        facade.addEntityManagerFactory(Persistence.createEntityManagerFactory("jpapu"));
        
        //Create
        Customer person1 = new Customer("Henry", "Williams", 46);
        System.out.println("createPerson: " + facade.createPerson(person1));
        
        //Get
        System.out.println("getPerson: " + facade.getPerson(1l));
        
        //Edit
        Customer person2 = new Customer("Jack", "Rogers", 67);
        person2.setId(1l);
        System.out.println("editPerson: " + facade.editPerson(person2));
        
        //Delete
        Customer person3 = new Customer();
        person3.setId(1l);
        //System.out.println("deletePerson: " + facade.deletePerson(person3));
    }
}
