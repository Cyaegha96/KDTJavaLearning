package dao;

import java.util.ArrayList;
import java.util.List;

import dto.MemberDTO;

public class MemberDAO {
	
	List<MemberDTO> members = new ArrayList<MemberDTO>();
	
	public void addMembers(String id, String password) {
		members.add(new MemberDTO(id, password));
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
