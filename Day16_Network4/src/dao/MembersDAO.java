package dao;

import java.util.ArrayList;
import java.util.List;

import dto.MemberDTO;

public class MembersDAO {
	List<MemberDTO> members = new ArrayList<>();

	public void addMembers(String id, String password, String name) {
		members.add(new MemberDTO(id, password, name));
	}
	
	public MemberDTO searchById(String id) {
		for(MemberDTO member: members) {
			if(member.getId().equals(id)) {
				return member;
			}
		
		}
		return null;
	}
	
	public boolean correctPassword(MemberDTO member, String password) {
		if(member.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	
	public int Size() {
		return members.size();
	}
	
	

}
