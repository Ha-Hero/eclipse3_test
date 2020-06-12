package bean;

public class bean {
	private int id;
	private String name;
	private String mail;
	private String form;
	private String time;

	public bean(int id,String name, String mail, String form, String time){
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.form = form;
		this.time = time;
	}

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getTime(){
		return time;
	}
	public void setTime(String time){
		this.time = time;
	}

}
