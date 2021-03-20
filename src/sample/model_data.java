package sample;

public class model_data {
	private String title;
	private String url;
	private double newValue;
	private double oldValue;
	
	public model_data() {
		// TODO Auto-generated constructor stub
	}
	

	public model_data(String title, String url, double newValue, double oldValue) {
		super();
		this.title = title;
		this.url = url;
		this.newValue = newValue;
		this.oldValue = oldValue;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getNewValue() {
		return newValue;
	}

	public void setNewValue(double newValue) {
		this.newValue = newValue;
	}

	public double getOldValue() {
		return oldValue;
	}

	public void setOldValue(double oldValue) {
		this.oldValue = oldValue;
	}
	
}
