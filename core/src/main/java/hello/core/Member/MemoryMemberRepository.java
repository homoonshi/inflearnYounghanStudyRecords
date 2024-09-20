package hello.core.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

  private static Map<Long, Member> store = new HashMap<>();
  // 동시성 이유로 ConcurrentHashMap() 써야 함

  @Override
  public void save(Member member) {
    store.put(member.getId(), member);
  }

  @Override
  public Member findById(Long memberId) {
    return store.get(memberId);
  }

}