package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

//            Order order = new Order();
//            order.addOrderItem(new OrderItem());

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");

            em.persist(book);

            List<Item> resultList = em.createQuery(
                    "select i from Item i where type(i) = Book ", Item.class)
                    .getResultList();

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
