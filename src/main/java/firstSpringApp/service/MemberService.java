package firstSpringApp.service;

import java.util.List;

import firstSpringApp.model.Member;

public interface MemberService {

	public List<Member> getMembers();

	public void add(Member member);
}
