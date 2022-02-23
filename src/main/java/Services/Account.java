package Services;

import Model.Staff;
import java.sql.ResultSet;

public interface Account {
    Staff login(String user, String pass);
    Staff extractStaffFromResultSet(ResultSet rs);
    boolean isloggedin();
}
