package com.bing.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "t_user")
@Entity
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_old")
    private Integer userOld;

    @Column(name = "user_book")
    private String userBook;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserOld() {
        return userOld;
    }

    public void setUserOld(Integer userOld) {
        this.userOld = userOld;
    }

    public String getUserBook() {
        return userBook;
    }

    public void setUserBook(String userBook) {
        this.userBook = userBook;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userOld=" + userOld +
                ", userBook='" + userBook + '\'' +
                '}';
    }
}
