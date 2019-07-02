
package friendsmanager.views;

import friendsmanager.controller.FriendController;
import friendsmanager.Model.Friend;
import friendsmanager.Model.Model;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FriendView {

    //attributes
    private final FriendController control;
    private final Model model;
    private final FriendMenu menu;

    /**
     * constructor
     * @param control
     * @param model 
     */
    public FriendView(FriendController control, Model model) {
        this.control = control;
        this.model = model;
        this.menu = new FriendMenu();
    }

    /**
     * Shows an input dialog
     * @param message
     * @return 
     */
    public String showInputDialog(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    /**
     * Displays a message.
     * @param message to display
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays a form with data of friend f.
     * @param f friend to show
     */
    public void showFriendForm(Friend f) {
        System.out.println(f.toString());
    }
    
    /**
     * Shows the list of all friends
     * @param f 
     */
    public void showListFriends(List<Friend> f) {
        for(Friend friend : f){
           System.out.println(friend.toString()); 
        }
        
    }

    /**
     * Shows the view.
     */
    public void display() {
        do {
            menu.show();
            String action = menu.getSelectedOptionActionCommand();
            control.executeAction(action);           
        } while (true);
    } 
    
    /**
     * Reads the new data in order to add a new friend
     * @return f
     */
    public Friend readInputFriend(){
        Scanner sc = new Scanner(System.in);
        long id = 0;
        
        try{
            System.out.println("Enter a id: ");
            id = sc.nextLong();
            sc.nextLine();
            System.out.println("Enter a name: ");
            String name = sc.nextLine();
            System.out.println("Enter an address: ");
            String address = sc.nextLine();
            System.out.println("Enter a phone: ");
            String phone = sc.nextLine();            
            System.out.println("Enter an age: ");
            int age = sc.nextInt();
            sc.nextLine();
            Friend f = new Friend(id,name,address,phone,age);
            return f;
                        
        }catch(InputMismatchException e){
            showMessage("Error reading friend");
            Friend f = null;
            return f;
        }
        
    }
    /**
     * Reads the new data in order to update a friend
     * @param f
     * @return 
     */
    public Friend readUpdateFriend(Friend f) {
        
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a name- "+f.getName()+" :");
            String name = sc.nextLine();
            System.out.print("Enter a phone- "+f.getPhone()+" :");
            String phone = sc.nextLine();
            System.out.print("Enter address- "+f.getAddress()+" :");
            String address = sc.nextLine();

            System.out.print("Enter an age- "+f.getAge()+" :");

            int age = sc.nextInt();
            sc.nextLine();
            Friend f2= new Friend(name, address, phone, age);
            return f2;
        } catch (InputMismatchException e) {
            showMessage("Error reading field...");
            Friend f2 = null;
            return f2;
        }

    }
    
        
}//end of class
