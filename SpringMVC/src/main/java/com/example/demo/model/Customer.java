package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int Cid;
		String Cname;
		String Caddress;
		
		
		public Customer() {
			super();
		}
		
		public Customer(int cid, String cname, String caddress) {
			super();
			Cid = cid;
			Cname = cname;
			Caddress = caddress;
		}
		
		public int getCid() {
			return Cid;
		}
		public void setCid(int cid) {
			Cid = cid;
		}
		public String getCname() {
			return Cname;
		}
		public void setCname(String cname) {
			Cname = cname;
		}
		public String getCaddress() {
			return Caddress;
		}
		public void setCaddress(String caddress) {
			Caddress = caddress;
		}

		@Override
		public String toString() {
			return "Customer [Cid=" + Cid + ", Cname=" + Cname + ", Caddress=" + Caddress + "]";
		}
		
		
}
