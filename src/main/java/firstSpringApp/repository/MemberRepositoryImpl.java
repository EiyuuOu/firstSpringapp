package firstSpringApp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
//		Member member1 = new Member("Niko","Brah", "niko@bla.de", "abc123");
//		Member member2 = new Member("John","Rambo", "john@bla.de", "abc123");
//		Member member3 = new Member("James","Bond", "james@bla.de", "abc123");
//		
//		members.add(member1);
//		members.add(member2);
//		members.add(member3);
		String sql = "select * from member";
		this.jdbcTemplate.query(sql, new MemberMapper());
		
		return members;
	}

	@Override
	public void addMember(Member newMember) {
		String sql = "insert into member(id,name,surname,email,password,registered) values(memberseq.nextval,?,?,?,?,?)";
		this.jdbcTemplate.update(sql, newMember.getName(), newMember.getSurname(), newMember.getEmail(), newMember.getPassword(), newMember.getRegistered());
		
	}
}

class MemberMapper implements RowMapper<Member>{

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {

		String name = rs.getString("name");
		String surname = rs.getString("surname");
		String email = rs.getString("email");
		String password = rs.getString("password");
		
		return new Member(name, surname, email, password);	
	}
	
}
