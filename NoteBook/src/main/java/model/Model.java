package model;

import java.util.Date;

import model.Entity.Address;
import model.Entity.Note;

public class Model {
	Note note = new Note();
	Address address = new Address();

	public void setUserData(int index, String input) {
		switch (index) {
		case 0:
			note.setLastName(input);
			break;
		case 1:
			note.setFirstName(input);
			break;
		case 2:
			note.setMiddleName(input);
			break;
		case 3:
			note.setNickName(input);
			break;
		case 4:
			note.setCommentary(input);
			break;
		case 5:
			note.setGroup(input);
			break;
		case 6:
			note.setHomePhoneNumber(input);
			break;
		case 7:
			note.setMobilePhoneNumber(input);
			break;
		case 8:
			note.setAlternativephoneNumber(input);
			break;
		case 9:
			note.setEmail(input);
			break;
		case 10:
			note.setSkype(input);
			break;
		case 11:
			address.setPostIndex(input);
			break;
		case 12:
			address.setCity(input);
			break;
		case 13:
			address.setStreet(input);
			break;
		case 14:
			address.setHouseNumber(input);
			break;
		case 15:
			address.setFlatNumber(input);
			note.setCreatedDate(new Date().toString());
			note.setAddress(address);
			break;
		}
	}

}
