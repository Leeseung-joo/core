package hello.core.member;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Getter
@Component
public class MemberServiceImpl implements MemberService{
    //테스트 용도
    private final MemberRepository memberRepository;
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {//memberRepository에 뭐가 들어갈지는 생성자에 의해 결정될 것임
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    } //반환 타입이 없어서 void사용

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
