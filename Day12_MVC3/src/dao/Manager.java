package dao;

import java.util.Arrays;

import dto.Member;

public class Manager {
	
	Member[] members = new Member[100];
	int memberCounts = 0;
	
	public void addMembers(Member member) {
		members[memberCounts] = member;
		memberCounts++;
	}
	
	
	public int getMemberCounts() {
		return memberCounts;
	}
	
	public int getMemberIndex(int id) {
		for(int i=0;i<memberCounts;i++) {
			if(members[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	public int getMemberIndex(String name) {
		for(int i=0;i<memberCounts;i++) {
			if(members[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public void updateMember(Member member,int index) {
		members[index] = member;
	}
	
	public void deleteMember(int index) {
		
		for(int i=index;i<memberCounts-1;i++) {
			members[i] = members[i+1];
		}
		memberCounts--;
		
	}
	
	
	public Member[] getMembers() {
		return members;
	}
	
	public boolean isDupId(int newId) {

		for(int i=0;i<memberCounts;i++) {
			if(members[i].getId() == newId) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isDupName(String name) {

		for(int i=0;i<memberCounts;i++) {
			if(members[i].getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public Member[] searchByName(String targetName) {
		Member[] result =new Member[memberCounts ];
		
		int j=0;
		for(int i=0;i<memberCounts ;i++) {
			if(this.members[i].getName().contains(targetName)) {
				result[j++] = members[i];
			}
		}
		return Arrays.copyOfRange(result, 0, j);
	
	}
	
	
	public Member[] getSearchByName(String str) {
		
		int selectedCount= 0;
		
		for(int i=0;i<memberCounts;i++) {
			if(this.members[i].getName().contains(str)) {
				selectedCount++;
			}
		}
		
		Member[] selectedMembers= new Member[selectedCount];  
		int tempCount = 0;
		
		for(int i=0;i<memberCounts;i++) {
			if(this.members[i].getName().contains(str)) {
				selectedMembers[tempCount] = members[i];
				tempCount++;
			}
		}
		
		return selectedMembers;
	}
	

}
