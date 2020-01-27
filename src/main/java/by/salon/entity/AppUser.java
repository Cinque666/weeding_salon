package by.salon.entity;

import javax.persistence.*;

@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long appUserId;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private Integer roleId;

    public long getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(long appUserId) {
        this.appUserId = appUserId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppUser appUser = (AppUser) o;

        if (appUserId != appUser.appUserId) return false;
        if (login != null ? !login.equals(appUser.login) : appUser.login != null) return false;
        if (password != null ? !password.equals(appUser.password) : appUser.password != null) return false;
        return roleId != null ? roleId.equals(appUser.roleId) : appUser.roleId == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (appUserId ^ (appUserId >>> 32));
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        return result;
    }
}
