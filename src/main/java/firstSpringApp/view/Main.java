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
		
		Member member = new Member("John", "Rambo", "blue@light.com", "654321");
		service.add(member);
		
//		List<Member> members = service.getMembers();
//		
//		for (Member member : members) {
//			System.out.println(member);
//		}
		
		System.out.println();
		ProductRepository repo1 = context.getBean("repo1",ProductRepository.class);
		List<Product> products = repo1.getProducts();
		
		for (Product product : products) {
			System.out.println(product);
		}
		
		
	((ClassPathXmlApplicationContext)context).close();
	}
		
	
}
