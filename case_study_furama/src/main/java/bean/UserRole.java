package bean;

public class UserRole {
    int roleId;
    String username;

    public UserRole() {
    }

    public UserRole(int roleId, String username) {
        this.roleId = roleId;
        this.username = username;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
