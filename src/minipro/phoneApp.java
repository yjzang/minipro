package minipro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class phoneApp {

	
	public static void main(String[] args) throws IOException {
		
		
		List<Person> list = new ArrayList<Person>();
		
		Scanner sc= new Scanner(System.in);
		
		Reader fr = new FileReader("phoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
	
		
		
		System.out.println("*******************************");
		System.out.println("*       전화번호 관리 프로그램           *");
		System.out.println("*******************************");
		
		
		
		while(true) {	
		
		System.out.println("------------------------------");	
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
		System.out.println("------------------------------");
		System.out.print(">메뉴번호: ");
		
			
			while(true) {	
				
				String str= br.readLine();
				
				if(str==null) {
					break;
				}
			
				String[] info = str.split(",");
				
				Person person = new Person(info[0],info[1],info[2]);
				list.add(person);
				
			}
			
			int choice;
			choice = sc.nextInt();
			
			if(choice==1) {
				
				
				System.out.println("\n<1. 리스트>");
				for(int i=0; i<list.size(); i++) {
				System.out.println((i+1)+". "+ list.get(i).getName()+" "+list.get(i).getHp()+" "+list.get(i).getCompany());
				}
				
				
				
			}
			
			else if(choice==2) {
				
				sc.nextLine();
				String name,hp,company;
				System.out.println("\n<2. 등록>");
				
				System.out.print(">이름: ");
				name=sc.nextLine();
				
				System.out.print(">휴대전화: ");
				hp=sc.nextLine();
				
				
				System.out.print(">회사전화: ");
				company=sc.nextLine();
				
				Person newPerson = new Person(name,hp,company);
				
				list.add(newPerson);
				
				Writer fw = new FileWriter("phoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(int i=0; i<(list.size()-1); i++) {
					bw.write(list.get(i).getName()+","+list.get(i).getHp()+","+list.get(i).getCompany());
					bw.newLine();
				}
				bw.close();

				
			}
			
			else if(choice==3) {
				
				System.out.println("\n<3. 삭제>");
				System.out.print(">번호: ");
				int num = sc.nextInt();
				list.remove((num-1));
				
				Writer fw = new FileWriter("phoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(int i=0; i<list.size(); i++) {
					bw.write(list.get(i).getName()+","+list.get(i).getHp()+","+list.get(i).getCompany());
					bw.newLine();
				}
				bw.close();
				
				
			}
			
			else if(choice==4) {
				sc.nextLine();
				System.out.println("\n<4. 검색>");
				System.out.print(">이름: ");
				String search = sc.nextLine();
				for(int i=0; i<list.size(); i++) {

					if(list.get(i).getName().contains(search)) {
						System.out.println((i+1)+". "+ list.get(i).getName()+" "+list.get(i).getHp()+" "+list.get(i).getCompany());
					}
					
				}
				
				
			}
			else if(choice==5) {
				
				Writer fw = new FileWriter("phoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(int i=0; i<list.size(); i++) {
					bw.write(list.get(i).getName()+","+list.get(i).getHp()+","+list.get(i).getCompany());
					bw.newLine();
				}
					
				
				bw.close();
				
				System.out.println("*******************************");
				System.out.println("*          감사합니다.           *");
				System.out.println("*******************************");
				break;
			}
			
			
			
			else {
				
				System.out.println("[다시 입력해주세요]");
				continue;
			}
			
		}
		br.close();
		sc.close();
	}
}
