package jpql;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Collections;
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

//            Member member = new Member();
//            member.setUsername("관리자");
//            member.setAge(10);
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//            member.changeTeam(team);
//            member.setType(MemberType.ADMIN);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

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
//            String query = "select size(t.members) from Team t";
//            List<Integer> resultList = em.createQuery(query, Integer.class).getResultList();
//
//            for (Integer s : resultList) {
//                System.out.println("s = " + s);
//            }

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

//            Team team = new Team();
//            em.persist(team);
//
//            Member member1 = new Member();
//            member1.setUsername("관리자1");
//            member1.changeTeam(team);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("관리자2");
//            member2.changeTeam(team);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
////            String query = "select m.username From Member m";
////            String query = "select m.team From Member m";
////            String query = "select size(t.members) From Team t";
//            String query = "select t.members From Team t";
//
//            Collection result = em.createQuery(query, Collection.class)
//                    .getResultList();
//
//            System.out.println("result = " + result);

            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.changeTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.changeTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.changeTeam(teamB);
            em.persist(member3);

//            String query = "select m From Member m";
//
//            List<Member> result = em.createQuery(query, Member.class).getResultList();
//
//            for (Member member : result) {
//                System.out.println("member = " + member.getUsername() +", "+ member.getTeam().getName());
//                // 회원1, 팀A (SQL)
//                // 회원2, 팀A (1차 캐시)
//                // 회원3, 팀B (SQL)
//            }

//            String query = "select m From Member m join fetch m.team";
//
//            List<Member> result = em.createQuery(query, Member.class).getResultList();
//
//            for (Member member : result) {
//                System.out.println("member = " + member.getUsername() +", "+ member.getTeam().getName());
//            }

//            // 컬렉션 페치 조인
//            String query = "select t From Team t join fetch t.members";
//
//            List<Team> result = em.createQuery(query, Team.class).getResultList();
//
//            for (Team team : result) {
//                System.out.println("team = " + team.getName()+", "+team.getMembers().size());
//                for (Member member : team.getMembers()) {
//                    System.out.println("member = " + member);
//                }
//            }

//            String query = "select t From Team t join t.members m";
//
//            List<Team> result = em.createQuery(query, Team.class).getResultList();
//
//            for (Team team : result) {
//                System.out.println("team = " + team.getName()+", "+team.getMembers().size());
//                for (Member member : team.getMembers()) {
//                    System.out.println("member = " + member);
//                }
//            }

//            String query = "select m From Member m where m = :member";
//
//            Member findMember = em.createQuery(query, Member.class)
//                    .setParameter("member", member1)
//                    .getSingleResult();
//
//            System.out.println("findMember = " + findMember);

//            String query = "select m From Member m where m.team = :team";
//
//            List<Member> findMember = em.createQuery(query, Member.class)
//                    .setParameter("team", teamA)
//                    .getResultList();
//
//            System.out.println("findMember = " + findMember);

//            Member findMember = em.createNamedQuery("Member.findByUsername", Member.class)
//                    .setParameter("username", "회원1")
//                    .getSingleResult();
//
//            System.out.println("findMember = " + findMember);

            // FLUSH 자동 호출 commit, query, flush
            int resultCount = em.createQuery("update Member m set m.age = 35")
                    .executeUpdate();

            System.out.println("resultCount = " + resultCount);

            em.clear();

            Member findMem = em.find(Member.class, member1.getId());
            System.out.println("findMem.getAge() = " + findMem.getAge());

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
