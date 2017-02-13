package firstSpringApp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import firstSpringApp.model.Member;

public class MemberRepositoryImpl implements MemberRepository {

	private List<Member> members;
	private JdbcTemplate jdbcTemplate;
	
	public MemberRepositoryImpl(JdbcTemplate jdbcTemplate){
		this.members = new ArrayList<Member>();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/* (non-Javadoc)
	 * @see firstSpringApp.repository.MemberRepository#getMembers()
	 */
	@Override
	public List<Member> getMembers(){
		Member member1 = new Member("Niko","Brah", "niko@bla.de", "abc123");
		Member member2 = new Member("John","Rambo", "john@bla.de", "abc123");
		Member member3 = new Member("James","Bond", "james@bla.de", "abc123");
		
		members.add(member1);
		members.add(member2);
		members.add(member3);
		
		return members;
	}

	@Override
	public void addMember(Member newMember) {
		String sql = "insert into member(id,name,surname,email,password) values(memberseq.nextval,?,?,?,?)";
		this.jdbcTemplate.update(sql, newMember.getName(), newMember.getSurname(), newMember.getEmail(), newMember.getPassword());
		
	}
}
