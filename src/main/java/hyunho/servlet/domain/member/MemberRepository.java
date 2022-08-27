package hyunho.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    //static으로 했기에 MemberRepository가 아무리 많아도 하나만 생성되서 공유한다.
    //동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
    private static Map<Long,Member> store = new HashMap<>(); // Key는 id Value는 Member
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository(); //싱글톤으로 하기 위함

    private MemberRepository(){ // 스프링을 사용안하고 있으니 private생성자로 싱글톤을 유지시켜줌.
    }

    public static MemberRepository getInstance(){
        return instance;
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
