package firstSpringApp.view;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import firstSpringApp.model.Member;
import firstSpringApp.model.Product;
import firstSpringApp.repository.MemberRepository;
import firstSpringApp.repository.ProductRepository;
import firstSpringApp.service.MemberService;


public class Main {

	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//call from repository
//		MemberRepository repo = context.getBean("repo", MemberRepository.class);
//		List<Member> members = repo.getMembers();
		//call from service
		MemberService service = context.getBean(MemberService.class);
		
//		Member member1 = new Member("John", "Rambo", "blue@light.com", "654321");
//		Member member2 = new Member("Donald", "Trump", "don@us.gov", "321456");
//		Member member3 = new Member("Arnold", "Schwarzenegger", "termi@na.tor", "0111010");
//		service.add(member1);
//		service.add(member2);
//		service.add(member3);
		
		List<Member> members = service.getMembers();
		
		for (Member member : members) {
			System.out.println(member);
		}
		
		System.out.println();
		ProductRepository repo1 = context.getBean("repo1",ProductRepository.class);
		List<Product> products = repo1.getProducts();
		
		for (Product product : products) {
			System.out.println(product);
		}
		
		
	((ClassPathXmlApplicationContext)context).close();
	}
		
	
}
