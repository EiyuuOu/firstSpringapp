package firstSpringApp.service;

import java.util.List;

import firstSpringApp.model.Member;
import firstSpringApp.repository.MemberRepository;

public class MemberServiceImpl implements MemberService {
	
	private MemberRepository repo;
	
	public MemberServiceImpl(MemberRepository repo){
		this.repo = repo;
		System.out.println("Hello from Member Constructor!");
	}

	@Override
	public List<Member> getMembers() {
		return repo.getMembers();
	}

	@Override
	public void add(Member member) {
		repo.addMember(member);
		
	}

}
