/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendsmanager;

import friendsmanager.Model.Model;
import friendsmanager.controller.FriendController;

/**
 *
 * @author elisabet
 */
public class FriendsManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FriendsManager myApp = new FriendsManager();
        myApp.run();
    }

    private void run() {
        Model model = new Model();
        FriendController controller = new FriendController(model);
    }
    
    //ACORDARSE DE properties -> library -> mySQLDriver
}
