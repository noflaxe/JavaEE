package models;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: noflaxe
 * Date: 20.07.13
 * Time: 13:10
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="ROLES")
@NamedQueries({
@NamedQuery(name="Role.findByAll",query = "FROM Role where login =:login")
})
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SEQ_GEN")
    @SequenceGenerator(name="SEQ_GEN", sequenceName="ID_SEQ", allocationSize=1)
    @Column(name="ROLE_ID")
    private long roleId;
    @Column(name="LOGIN")
    private String login;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="ROLE")
    private String role;
    @OneToOne(mappedBy="role")
    private Worker worker;

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (login != null ? !login.equals(role.login) : role.login != null) return false;
        if (password != null ? !password.equals(role.password) : role.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Role() {
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
