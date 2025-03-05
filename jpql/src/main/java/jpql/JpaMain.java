package jpql;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
//            for (int i = 0; i < 100; i++) {
//                Member member = new Member();
//                member.setUsername("member"+ i);
//                member.setAge(i);
//                em.persist(member);
//            }

//            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
//            TypedQuery<String> query2 = em.createQuery("select m.username, m.age from Member m", String.class);
//            Query query3 = em.createQuery("select m.username, m.age from Member m");
//
//            Member result = query1.getSingleResult();
//            // Spring Date JPA -> 결과가 없으면 Optional 반환 Exception 안터뜨림
//            System.out.println("result = " + result);

//            TypedQuery<Member> query = em.createQuery("select m from Member m where m.username = :username", Member.class);
//            query.setParameter("username", "member1");
//            Member singleResult = query.getSingleResult();
//            System.out.println("singleResult = " + singleResult.getUsername());
//
//            Member result = em.createQuery("select m from Member m where m.username = :username", Member.class)
//                    .setParameter("username", "member1")
//                    .getSingleResult();
//            System.out.println("result = " + result.getUsername());

//            em.flush();
//            em.clear();

//            List<Member> result = em.createQuery("select m from Member m", Member.class)
//                    .getResultList();
//
//            Member findMember = result.get(0);
//            findMember.setAge(20);

//            List<Member> result = em.createQuery("select t from Member m join m.team t", Member.class)
//                    .getResultList();

//            List<Address> result = em.createQuery("select o.address from Order o", Address.class)
//                    .getResultList();

//            List resultList = em.createQuery("select distinct m.username, m.age from Member m").getResultList();
//
//            Object o = resultList.get(0);
//            Object[] result = (Object[]) o;
//            System.out.println("username = " + result[0]);
//            System.out.println("age = " + result[1]);

//            List<Object[]> resultList = em.createQuery("select distinct m.username, m.age from Member m").getResultList();
//
//            Object[] result = resultList.get(0);
//            System.out.println("result = " + result[0]);
//            System.out.println("result = " + result[1]);

//            List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class).getResultList();
//
//            MemberDTO memberDTO = resultList.get(0);
//            System.out.println("memberDTO = " + memberDTO.getUsername());
//            System.out.println("memberDTO = " + memberDTO.getAge());

//            List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            System.out.println("result.size() = " + result.size());
//            for (Member member1 : result) {
//                System.out.println("member1 = " + member1);
//            }

            Member member = new Member();
            member.setUsername("관리자");
            member.setAge(10);
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);
            member.changeTeam(team);
            member.setType(MemberType.ADMIN);

            em.persist(member);

            em.flush();
            em.clear();

//            String query =
//                    "select " +
//                            "case when m.age <= 10 then '학생요금'" +
//                            "     when m.age >= 60 then '경로요금'" +
//                            "     else '일반요금' "+
//                            "end "+
//                            "from Member m";

//            String query = "select coalesce(m.username, '이름 없는 회원') from Member m";
//            String query = "select NULLIF(m.username, '관리자') from Member m";
//            String query = "select concat('a','b') from Member m";
//            String query = "select locate('de','abcdegf') from Member m";
            String query = "select size(t.members) from Team t";
            List<Integer> resultList = em.createQuery(query, Integer.class).getResultList();

            for (Integer s : resultList) {
                System.out.println("s = " + s);
            }

//
////            String query = "select m from Member m, Team t where m.username = t.name";
////            String query = "select m from Member m left join m.team t on t.name = 'teamA'";
//            String query = "select m from Member m left join Team t on m.username = t.name";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();
//
//            System.out.println("result = " + result);

//            String query = "select m.username, 'HELLO', TRUE From Member m " +
//                            "where m.type = :userType";
//            List<Object[]> result= em.createQuery(query)
//                    .setParameter("userType", MemberType.ADMIN)
//                    .getResultList();
//
//            for (Object[] objects : result) {
//                System.out.println("objects = " + objects[0]);
//                System.out.println("objects = " + objects[1]);
//                System.out.println("objects = " + objects[2]);
//            }

            tx.commit();
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();

    }

}
