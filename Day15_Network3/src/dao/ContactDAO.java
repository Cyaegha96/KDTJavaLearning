package dao;

import java.util.ArrayList;
import java.util.List;


import dto.ContactDTO;

public class ContactDAO {
	
	static final int ID_START = 1001;
	
	List<ContactDTO> contactList = new ArrayList<ContactDTO>();
	
	public void updateContact(int id, String name, String phone) {
		contactList.get(id-1001).setName(name);
		contactList.get(id-1001).setPhone(phone);
	}
	
	public void removeContact(int id) {
		contactList.remove(id-1001);
	}
	
	
	public boolean hasId(int id) {
		for(ContactDTO dto: contactList) {
			if(dto.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public void addContact(String name, String phone) {
		
		contactList.add(new ContactDTO(ID_START+Size(), name, phone));
	}
	
	public int Size() {
		return contactList.size();
	}
	
	public List<ContactDTO> getContactLists(){
		return contactList;
	}
	
	public List<ContactDTO> searchByName(String name){
		
		List<ContactDTO> result = new ArrayList<ContactDTO>();
		for(ContactDTO dto: contactList) {
			if(dto.getName().contains(name)) {
				result.add(dto);
			}
		}
		return result;
	}

}
