public class Registro {
	private int id;
	private String name;
	private String date;
	private String time;
	private float value;
	private String description;

	private registro(int id,
			String name,
			String date,
			String time,
			float value,
			String description
			) {
		this.id = id;
		this.name = name;
		this.time = time;
		this.value = value;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTime() {
		return time;
	}

	public float getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
