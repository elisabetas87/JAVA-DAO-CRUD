/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendsmanager.controller;

import friendsmanager.Model.Friend;
import friendsmanager.Model.Model;
import friendsmanager.views.FriendView;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author elisabet
 */
public class FriendController {
    //attributes
    private Model model;
    private FriendView view;

    /**
     * constructor
     * @param model 
     */
    public FriendController(Model model) {
        this.model = model;
        this.view = new FriendView(this,model);
        view.display();
    }
    
    /**
     * Finish the app.
     */
    public void exitApplication(){
        System.exit(0);
    }
    
    /**
     * Finds a friend by id.
     */
    public void findById(){
        try{
            long id=Long.parseLong(view.showInputDialog("Input id: "));
            Friend f = model.findById(id);
            
            if(f!=null){
                view.showFriendForm(f);
            }else{
                view.showMessage("Friend not found");
            }
            
        }catch(NumberFormatException e){
            view.showMessage("Error reading id");
        }
    }
    
    /**
     * Finds a friend by name.
     */
    public void findByName(){
        try{
           String name=view.showInputDialog("Input name: ");
            List<Friend> lf = model.findByName(name);
            
            if(lf!=null){
                view.showListFriends(lf);
            }else{
                view.showMessage("Friend not found");
            }
            
        }catch(NumberFormatException e){
            view.showMessage("Error reading name");
        }
    }
    
    /**
     * Finds a friend by phone.
     */
    public void findByPhone(){
        try{
           String phone=view.showInputDialog("Input phone: ");
            List<Friend> lf = model.findByPhone(phone);
            
            if(lf!=null){
                    view.showListFriends(lf);
            }else{
                view.showMessage("Friend not found");
            }
            
        }catch(NumberFormatException e){
            view.showMessage("Error reading phone");
        }
    }
    
    /**
     * Adds a friend.
     */
    public void addFriend(){
        try{
            Friend f = view.readInputFriend();
            if(f!=null){
                view.showFriendForm(f);
                Scanner sc = new Scanner(System.in);
                System.out.println("Are you sure you want to add a friend?(y/n)");
                String del = sc.nextLine();
                if(del.equals("Y")||del.equals("y")){
                    if(model.addFriend(f) != 0){
                        view.showMessage("Friend has been added correctly");
                    }else{
                        view.showMessage("Friend has not been added");
                    }
                }
            }else{
                view.showMessage("Friend is empty");
            }
        }catch(NumberFormatException e){
            view.showMessage("Error reading id");
        }
    }
    
    /**
     * Updates a friend.
     */
    public void updateFriend(){
       try {
            long id = Long.parseLong(view.showInputDialog("Input id to update:"));
            Friend f = model.findById(id);
            if (f != null) {
                view.showFriendForm(f);
                Scanner read = new Scanner(System.in);
                System.out.println("Are you sure you want to update friend (y/n)?");
                String del = read.next();
                if (del.equals("Y") || (del.equals("y"))) {
                    Friend f2 = view.readUpdateFriend(f);
                    view.showMessage("New data friend to update...");
                       
                    if (model.updateFriend(f2,id) != 0) {
                        view.showMessage("Friend has been updated correctly");
                    } else {
                        view.showMessage("Friend has not been updated...");
                    }

                }
            } else {
                view.showMessage("Friend not found");
            }
        } catch (NumberFormatException e) {
            view.showMessage("Error reading id");
        }
    }
    
    /**
     * Deletes a friend.
     */
    public void deleteFriend(){
        try{
            long id=Long.parseLong(view.showInputDialog("Input id to delete: "));
            Friend f = model.findById(id);
      
            if(f!=null){
                view.showFriendForm(f);
                Scanner sc = new Scanner(System.in);
                System.out.println("Are you sure you want to delete a friend?");
                String del = sc.next();
                if(del.equals("Y")||del.equals("y")){
                    
                    if(model.deleteFriend(f) != 0){
                        view.showMessage("Friend has been deleted successfully");
                    }else{
                        view.showMessage("Friend has not been deleted");
                    }
                }
            }else{
                view.showMessage("Friend not found");
            }
        }catch(NumberFormatException e){
            view.showMessage("Error reading id");
        }
    }
    
    /**
     * List all friends.
     */
    public void listAll() {
        try {
            List<Friend> listf = model.listAll();
            if (listf != null) {
                view.showListFriends(listf);
            } else {
                view.showMessage("Friends not found");
            }
        } catch (NumberFormatException e) {
            view.showMessage("Error reading friends");
        }
    }
    
    /**
     * Executes an action according to the input parameter
     * @param action 
     */
    public void executeAction(String action){
        switch(action){
            case "exit":
                exitApplication();
                break;
            case "find_by_id":
                findById();
                break;
            case "find_by_name":
                findByName();
                break;
            case "find_by_phone":
                findByPhone();
                break;
            case "add_friend":
                addFriend();
                break;
            case "update_friend":
                updateFriend();
                break;
            case "delete_friend":
                deleteFriend();
                break;
            case "list_all":
                listAll();
                break;
            default:
                view.showMessage("Wrong option");
                break;                
        }
    }
}
