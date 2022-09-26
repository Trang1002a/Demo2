package Entity;

public class CategoryEntity {
	private int id;
	private String name;
	private int status;
	private int parentId;
	public CategoryEntity() {
		super();
	}
	public CategoryEntity(int id, String name, int status, int parentId) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.parentId = parentId;
	}
	public CategoryEntity(String name, int status, int parentId) {
		super();
		this.name = name;
		this.status = status;
		this.parentId = parentId;
	}
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	
}
