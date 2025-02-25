package hellojpa;

import hellojpa.domain.Item;
import hellojpa.domain.Member;
import hellojpa.domain.Movie;
import hellojpa.domain.Team;
import jakarta.persistence.*;
import org.hibernate.Hibernate;
import org.hibernate.jpa.internal.PersistenceUnitUtilImpl;

import java.time.LocalDateTime;
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

//            Member member1 = new Member();
//            member1.setName("A");
//            Member member2 = new Member();
//            member2.setName("B");
//            Member member3 = new Member();
//            member3.setName("C");
//
//            System.out.println("====================");
//            em.persist(member1); // 1, 51
//            em.persist(member2); // MEMORY
//            em.persist(member3); // MEMORY
//            System.out.println("====================");

            // 단방향 매핑관계 사용 전
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, member.getId());
//
//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);

            // 단방향 매핑관계 사용 후
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, member.getId());
//            Team findTeam = findMember.getTeam();
//
//            System.out.println("findTeam = " + findTeam.getName());
//
//            Team newTeam = em.find(Team.class, 100L);
//            findMember.setTeam(newTeam);

            // 양방향 연관관계
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//
//            for (Member m : members) {
//                System.out.println("m.getUsername() = " + m.getUsername());
//            }

            // 양방향 연관관계 주인에 값 입력 X
//            Member member = new Member();
//            member.setUsername("member1");
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("TeamA");
//            team.getMembers().add(member);
//            em.persist(team);

//            // 연관관계의 주인 입력 O
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.changeTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Team findTeam = em.find(Team.class, team.getId());
//            List<Member> members = findTeam.getMembers();
//
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }

//            Movie movie = new Movie();
//            movie.setDirector("aaaa");
//            movie.setActor("bbbb");
//            movie.setName("바람과 함께 사라지다");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Item findItem = em.find(Item.class, movie.getId());
//            System.out.println("findMovie = " + findItem.getId());

//            Member member = new Member();
//            member.setUsername("user1");
//            member.setCreatedBy("kim");
//            member.setCreatedDate(LocalDateTime.now());
//
//            em.persist(member);
//            em.flush();
//            em.clear();

//            Member member = em.find(Member.class, 1L);
//            printMember(member);
////            printMemberAndTeam(member);

            Member member1 = new Member();
            member1.setUsername("hello1");
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("hello2");
            em.persist(member2);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass());
            System.out.println("isLoaded() = " + emf.getPersistenceUnitUtil().isLoaded(refMember)); // 프록시 인스턴스 초기화 여부 확인
            Hibernate.initialize(refMember); // 강제 초기화

//            em.detach(refMember);
//
//            System.out.println("refMember = " + refMember.getUsername());


//            Member findMember = em.find(Member.class, member1.getId());
//            System.out.println("findMember = " + findMember.getClass());
//
//            System.out.println("findMember == refMember " + (findMember == refMember));


//            Member m2 = em.getReference(Member.class, member2.getId());


//            System.out.println("m2 = " + m2.getClass());
//            System.out.println("m1 == m2 : " + (m1 instanceof Member));
//            System.out.println("m1 == m2 : " + (m2 instanceof Member));
//            System.out.println("m1 == m2 : " + (m1.getClass() == m2.getClass()));

//            Member findMember = em.getReference(Member.class, member1.getId());

//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("findMember.getClass() = " + findMember.getClass());
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getUsername() = " + findMember.getUsername());

            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();
    }

    private static void printMember(Member member) {
        System.out.println("member.getUsername() = " + member.getUsername());
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team.getName() = " + team.getName());
    }

}
