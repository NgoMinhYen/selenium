import core.DriverUtil;
import dataObject.ListUser;
import dataObject.User;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pages.SignupGlobeDrPage;

import java.util.List;
import java.util.Map;

public class SignUpStep {

    ListUser listUser = new ListUser();
    SignupGlobeDrPage signupGlobeDrPage = new SignupGlobeDrPage();

    @And("On web,Signup with user name and password and name")
    public void onWebSignupWithUserNameAndPasswordAndName(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> colums : rows) {
            listUser.addUser(new User(colums.get("phone"), colums.get("password"), colums.get("name")));
        }
        for (int i = 0; i < listUser.getUsers().size(); i++) {
            signupGlobeDrPage.signUp(
                    listUser.getUsers().get(i).getPhone(),
                    listUser.getUsers().get(i).getPass(),
                    listUser.getUsers().get(i).getName()

            );
        }

    }

    @And("I close page")
    public void iClosePage() {
        DriverUtil.waitingTime(3);
        DriverUtil.quit();
    }
}
