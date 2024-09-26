package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  // @Bean -> memberService -> new MemoryMemberRepository()
  // @Bean -> orderService -> 또 memberRepository? -> 또 new MemoryMemberRepository()? -> 싱글톤 깨지는거 아니야?
  // 과연 깨질까요 ?

  // configuration 에서 한정적으로 쓰는 필드 주입 (웬만하면 쓰지 않기)
//  @Autowired MemberRepository memberRepository;
//  @Autowired DiscountPolicy discountPolicy;

  @Bean
  public MemberService memberService(){
    System.out.println("call AppConfig.memberService");
    return new MemberServiceImpl(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    System.out.println("call AppConfig.memberRepository");
    return new MemoryMemberRepository();
  }

  @Bean
  public OrderService orderService(){
    System.out.println("call AppConfig.orderService");
    return new OrderServiceImpl(memberRepository(), discountPolicy());
//    return null;
  }

  @Bean
  public DiscountPolicy discountPolicy(){
    System.out.println("call AppConfig.discountPolicy");
    return new RateDiscountPolicy();
  }

}
