package execute;

import dao.JobDAO;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/17/13
 * Time: 4:36 PM
 * To change this template use File | Settings | File Templates.
 */

public class Main {



    public  static void main(String[] s) {
            JobDAO dao = new JobDAO();
       System.out.println(dao.find(1).getPosition());



    }
}
