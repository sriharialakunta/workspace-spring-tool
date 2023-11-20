package com.example.demo;

public class Employee {

		private int id;
		private String name;
		private String band;
		public Employee() {}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getBand() {
			return band;
		}
		public void setBand(String band) {
			this.band = band;
		}
		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", band=" + band + "]";
		}
		public Employee(int id, String name, String band) {
			super();
			this.id = id;
			this.name = name;
			this.band = band;
		}
		
}
