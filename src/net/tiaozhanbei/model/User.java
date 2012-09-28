package net.tiaozhanbei.model;
//relation（一个新的模型）表示用户与项目的关系,要判断该是不是该项目的owner,票数votetickets;last
import java.util.*;



import net.tiaozhanbei.util.CommonResources;
import net.tiaozhanbei.util.UserConst;
@SuppressWarnings("unchecked")
public class User{

    private int Id;
    private String name;
    private String password;
    private int type=UserConst.Type.COMMONUSER;
    private boolean verify=false;
    private int sex=UserConst.Sex.UNKNOWN;
    private String realName;
    private String phone;
    private String department;
    private String email;
    private Date registerTime=new Date();
    private Set favourateProjects=new HashSet();
    private Set interestProjects=new HashSet();
    private Set myProjects=new HashSet();
    private int score;
    

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isVerify() {
        return verify;
    }

    public void setVerify(boolean verify) {
        this.verify = verify;
    }

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


	public Set<Project> getFavourateProjects() {
		return favourateProjects;
	}

	public void setFavourateProjects(Set favourateProjects) {
		this.favourateProjects = favourateProjects;
	}

	public Set<Project> getInterestProjects() {
		return interestProjects;
	}

	public void setInterestProjects(Set interestProjects) {
		this.interestProjects = interestProjects;
	}

	public Set<Project> getMyProjects() {
		return myProjects;
	}

	public void setMyProjects(Set myProjects) {
		this.myProjects = myProjects;
	}
	


	/**
	 * 获得用户权限
	 * 返回的String是UserConst.Authority中的常数
	 * @return
	 */
	public List<String> getRoles(){
		ResourceBundle bundle=CommonResources.getUserTypeRolesBundle();
		String[] res;
		if(verify)
			res= bundle.getString(new Integer(type).toString()).split(",");
		else {
			res= bundle.getString(new Integer(UserConst.Type.COMMONUSER).toString()).split(",");
		}
		return Arrays.asList(res);
	}
}