/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendsmanager.persistence;

import friendsmanager.Model.Friend;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * In this class we implement the CRUD methods
 *
 * @author elisabet
 */
public class FriendDAO {
    //QUERIES
    private final String QUERY_FIND_BY_ID = "select * from friends where id=?";
    private final String QUERY_FIND_BY_NAME = "select * from friends where name=?";
    private final String QUERY_FIND_BY_PHONE = "select * from friends where phone=?";
    private final String QUERY_INSERT = "insert into friends (id, name, address, phone, age) values (?,?,?,?,?)";
    private final String QUERY_UPDATE = "update friends set name=?, address=?, phone=?, age=? where id=?";
    private final String QUERY_DELETE = "delete from friends where id=?";
    private final String QUERY_LIST_ALL = "select * from friends";

    /**
     * Find a friend by id
     * @param id
     * @return 
     */
    public Friend findById(long id) {
        Friend f = new Friend();
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(QUERY_FIND_BY_ID);
                st.setLong(1, id);
                ResultSet rs = st.executeQuery();
                rs.next();
                f = resultsetToFriend(rs);
            }
        } catch (SQLException | ClassNotFoundException e) {
            f = null;
        }
        return f;
    }

    /**
     * Find a friend by name
     * @param name
     * @return 
     */
    public List<Friend> findByName(String name) {
        ArrayList friends = new ArrayList<Friend>();
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(QUERY_FIND_BY_NAME);
                st.setString(1, name);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Friend f = new Friend();
                    f.setId(rs.getInt("id"));
                    f.setName(rs.getString("name"));
                    f.setPhone(rs.getString("phone"));
                    f.setAddress(rs.getString("address"));
                    f.setAge(rs.getInt("age"));

                    friends.add(f);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            friends = new ArrayList<>();
        }
        return friends;
    }

    /**
     * Find a friend by phone
     * @param phone
     * @return 
     */
    public List<Friend> findByPhone(String phone) {

        ArrayList friends = new ArrayList<Friend>();
        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(QUERY_FIND_BY_PHONE);
                st.setString(1, phone);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Friend f = new Friend();
                    f.setId(rs.getInt("id"));
                    f.setName(rs.getString("name"));
                    f.setPhone(rs.getString("phone"));
                    f.setAddress(rs.getString("address"));
                    f.setAge(rs.getInt("age"));

                    friends.add(f);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            friends = new ArrayList<>();
        }
        return friends;
    }

    /**
     * Inserts a friend
     * @param f
     * @return 
     */
    public int insert(Friend f) {

        int rowsAffected = 0;

        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(QUERY_INSERT);
                st.setLong(1, f.getId());
                st.setString(2, f.getName());
                st.setString(3, f.getAddress());
                st.setString(4, f.getPhone());
                st.setInt(5, f.getAge());

                rowsAffected = st.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            rowsAffected = 0;
        }
        return rowsAffected;
    }

    /**
     * Updates a friend
     * @param f
     * @param id
     * @return 
     */
    public int update(Friend f,long id) {

        int rowsAffected = 0;

        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(QUERY_UPDATE);
                st.setString(1, f.getName());
                st.setString(2, f.getAddress());
                st.setString(3, f.getPhone());
                st.setInt(4, f.getAge());
                st.setLong(5, id);
                rowsAffected = st.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            rowsAffected = 0;
        }
        return rowsAffected;
    }

    /**
     * Deletes a friend
     * @param f
     * @return 
     */
    public int delete(Friend f) {

        int rowsAffected = 0;

        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(QUERY_DELETE);
                st.setLong(1, f.getId());
                rowsAffected = st.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            rowsAffected = 0;
        }
        return rowsAffected;
    }

    /**
     * List all friends
     * @return 
     */
    public List<Friend> listAll() {
        ArrayList friends = new ArrayList<Friend>();

        try {
            DBConnect db = new DBConnect();
            Connection conn = db.getConnection();
            if (conn != null) {

                PreparedStatement st = conn.prepareStatement(QUERY_LIST_ALL);

                ResultSet res = st.executeQuery();
                while (res.next()) {
                    Friend f = new Friend();
                    f.setId(res.getInt("id"));
                    f.setName(res.getString("name"));
                    f.setAddress(res.getString("address"));
                    f.setPhone(res.getString("phone"));
                    f.setAge(res.getInt("age"));

                    friends.add(f);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            friends = new ArrayList<>();
        }
        return friends;

    }

    /**
     * Result set to friend
     * @param rs
     * @return
     * @throws SQLException 
     */
    private Friend resultsetToFriend(ResultSet rs) throws SQLException {
        Friend f = null;
        long idf = rs.getLong("id");
        String name = rs.getString("name");
        String address = rs.getString("address");
        String phone = rs.getString("phone");
        int age = rs.getInt("age");
        f = new Friend(idf, name, address, phone, age);
        return f;
    }
}
