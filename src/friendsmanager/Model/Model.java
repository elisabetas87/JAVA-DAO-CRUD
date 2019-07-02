/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendsmanager.Model;

import friendsmanager.persistence.FriendDAO;
import java.util.List;

/**
 *
 * @author elisabet
 */
public class Model {
   
    /**
     * Finds a friend by id
     * @param id
     * @return 
     */
    public Friend findById(long id){
      FriendDAO fd = new FriendDAO();
      return fd.findById(id);
    }
    
    /**
     * Finds a friend by name
     * @param name
     * @return 
     */
    public List<Friend> findByName(String name){
      FriendDAO fd = new FriendDAO();
      return fd.findByName(name);
    }
    
    /**
     * Finds a friend by phone
     * @param phone
     * @return 
     */
    public List<Friend> findByPhone(String phone){
        FriendDAO fd = new FriendDAO();
        return fd.findByPhone(phone);
    }
    
    /**
     * Adds a friend
     * @param f
     * @return 
     */
    public int addFriend(Friend f){
       FriendDAO fd = new FriendDAO();
        return fd.insert(f);
    }
    
    /**
     * Updates a friend
     * @param f
     * @param id
     * @return 
     */
    public int updateFriend(Friend f,long id){
        FriendDAO fd = new FriendDAO();
        return fd.update(f,id);
    }
    
    /**
     * Deletes a friend
     * @param f
     * @return 
     */
    public int deleteFriend(Friend f){
        FriendDAO fd = new FriendDAO();
        return fd.delete(f);
    }
    
    /**
     * Lists all friends
     * @return 
     */
    public List<Friend> listAll ( ) {
        FriendDAO fd = new FriendDAO();
        return fd.listAll();
    }
}
