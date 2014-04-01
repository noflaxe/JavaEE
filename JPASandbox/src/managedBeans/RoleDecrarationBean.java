package managedBeans;

import javax.annotation.security.DeclareRoles;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 7/15/13
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */

@ManagedBean(name="rolebean")
@ApplicationScoped
@DeclareRoles(value={"admin","worker"})
public class RoleDecrarationBean {


}
