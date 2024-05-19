package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 20;

    @Override
    public int discount(Member member, int price){
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100; //할인율을 적용하여 할인해주는 금액 반환

        }else{
            return 0;
        }
    }


}
