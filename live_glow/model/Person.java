package com.live_glow.model;

public class Person {
		private int PersonId;
		private String PersonName;
		private String Password;
		private String Email;
		private String Address;
		private long ContactNo;
		private String PersonType;
		 
	    public Person() {
			
		}


		public Person(int personId, String personName, String password, String email, String address, long ContactNo,
				String personType) {
			
			this.PersonId = personId;
			this.PersonName = personName;
			this.Password = password;
			this.Email = email;
			this.Address = address;
			this.ContactNo = ContactNo;
			this.PersonType = personType;
		}
		
		public Person(int personId, String password, String email) {
			
			this.PersonId = personId;
			this.Password = password;
			this.Email = email;
			}



		public int getPersonId() {
			return PersonId;
		}


		public void setPersonId(int personId) {
			this.PersonId = personId;
		}


		public String getPersonName() {
			return PersonName;
		}


		public void setPersonName(String personName) {
			this.PersonName = personName;
		}


		public String getPassword() {
			return Password;
		}


		public void setPassword(String password) {
			this.Password = password;
		}


		public String getEmail() {
			return Email;
		}


		public void setEmail(String email) {
			this.Email = email;
		}


		public String getAddress() {
			return Address;
		}


		public void setAddress(String address) {
			this.Address = address;
		}


		public long getContactNo() {
			return ContactNo;
		}


		public void setContactNo(long ContactNo) {
			this.ContactNo = ContactNo;
		}


		public String getPersonType() {
			return PersonType;
		}


		public void setPersonType(String personType) {
			this.PersonType = personType;
		}

		@Override
		public String toString() {
			return "Person [PersonId=" + PersonId + ", PersonName=" + PersonName + ", Password=" + Password + ", Email="
					+ Email + ", Address=" + Address + ", ContactNo=" + ContactNo + ", PersonType=" + PersonType + "]";
		}		
	}

