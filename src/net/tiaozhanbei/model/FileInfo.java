package net.tiaozhanbei.model;

public class FileInfo {

	public enum Type{
		Picture,Download,Movie
	}
	private int id;
    private String name;
    private String path;
    private Project project;
    private int access;
    private User owner;

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }
    
    public boolean testAccess(int userType){
    	return ((access & userType)!= 0);
    }
    
    public Type getType(){
    	return Type.Picture;
    }
}