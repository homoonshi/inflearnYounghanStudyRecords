package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, 2L);
//            findMember.setName("HelloJPA");
//
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//
//            for (Member mem : result) {
//                System.out.println("member.name = " + mem.getName());
//            }

//            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            // 영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");
//
//            Member findMember = em.find(Member.class, 101L);
//
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//
//            System.out.println("==========================");

//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush();
//            System.out.println("==========================");

            Member member1 = new Member();
            member1.setName("A");
            Member member2 = new Member();
            member2.setName("B");
            Member member3 = new Member();
            member3.setName("C");

            System.out.println("====================");
            em.persist(member1); // 1, 51
            em.persist(member2); // MEMORY
            em.persist(member3); // MEMORY
            System.out.println("====================");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
