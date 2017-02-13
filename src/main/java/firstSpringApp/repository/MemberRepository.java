package firstSpringApp.repository;

import java.util.List;

import firstSpringApp.model.Member;

public interface MemberRepository {

	public void addMember(Member newMember);
	List<Member> getMembers();

}