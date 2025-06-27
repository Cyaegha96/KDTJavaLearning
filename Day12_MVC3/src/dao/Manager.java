package dao;

import java.util.ArrayList;
import java.util.Arrays;

import dto.Member;

public class Manager {
	
	private ArrayList<Member> members = new ArrayList<>();
	
	public void addMembers(Member member) {
		members.add(member);
	}
	
	
	public int getMemberCounts() {
		return members.size();
	}
	
	public int getMemberIndex(int id) {
		for(int i=0;i<members.size();i++) {
			if(members.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	public int getMemberIndex(String name) {
		for(int i=0;i<members.size();i++) {
			if(members.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public void updateMember(Member member,int index) {
		members.set(index, member);
	}
	
	public void deleteMember(int index) {
		
		members.remove(index);
		
	}
	
	
	public ArrayList<Member> getMembers() {
		return members;
	}
	
	public boolean isDupId(int newId) {

		for(int i=0;i<members.size();i++) {
			if(members.get(i).getId() == newId) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isDupName(String name) {

		for(int i=0;i<members.size();i++) {
			if(members.get(i).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Member> searchByName(String targetName) {
		
		ArrayList<Member> newList = new ArrayList<Member>();
		for(int i=0;i<members.size() ;i++) {
			if(members.get(i).getName().contains(targetName)) {
				newList.add (members.get(i));
			}
		}
		return newList;
	
	}
}
