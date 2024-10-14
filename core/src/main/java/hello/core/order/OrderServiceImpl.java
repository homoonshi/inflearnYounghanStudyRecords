package hello.core.order;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.discount.DiscountPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
//@RequiredArgsConstructor // final 붙은 애들을 생성자 만들어줌 -> 생성자 주입
public class OrderServiceImpl implements OrderService{

  @Autowired private final MemberRepository memberRepository;
  @Autowired private final DiscountPolicy discountPolicy;

  @Autowired
  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

//  @Autowired
//  public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//    this.discountPolicy = discountPolicy;
//  }
//
//  @Autowired
//  public void setMemberRepository(MemberRepository memberRepository) {
//    this.memberRepository = memberRepository;
//  }



//  @Autowired
//  public void init(MemberRepository memberRepository,DiscountPolicy discountPolicy){
//    this.memberRepository = memberRepository;
//    this.discountPolicy = discountPolicy;
//  }

//  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//  private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//  private DiscountPolicy discountP/olicy;

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member,itemPrice);
    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

//  // 테스트 용도
//  public MemberRepository getMemberRepository() {
//    return memberRepository;
//  }

}
