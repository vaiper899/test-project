package com.dreamsyssoft.demo.rest.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.dreamsyssoft.demo.rest.dao.UserManagerDao;
import com.dreamsyssoft.demo.rest.model.User;
import com.dreamsyssoft.demo.rest.model.UserRequest;
import com.dreamsyssoft.demo.rest.model.UserResponse;
import com.dreamsyssoft.demo.rest.services.UserManager;

public class UserManagerService implements UserManager {
    private UserManagerDao userDao;

    public UserManagerDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserManagerDao userDao) {
        this.userDao = userDao;
    }

    public UserResponse fetchUserById(UserRequest request) {
        UserResponse response = new UserResponse();

        try {
            response.setUsers(Arrays.asList(getUserDao().fetchUserById(request.getUser().getId())));
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getClass() + ": " + e.getMessage());
        }

        return response;
    }

    public UserResponse insertUser(UserRequest request) {
        UserResponse response = new UserResponse();

        try {
            getUserDao().insertUser(request.getUser());
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getClass() + ": " + e.getMessage());
        }

        return response;
    }

    public UserResponse updateUser(UserRequest request) {
        UserResponse response = new UserResponse();

        try {
            getUserDao().updateUser(request.getUser());
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getClass() + ": " + e.getMessage());
        }

        return response;
    }

    public UserResponse deleteUser(UserRequest request) {
        UserResponse response = new UserResponse();

        try {
            getUserDao().deleteUser(request.getUser());
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getClass() + ": " + e.getMessage());
        }

        return response;
    }

    public UserResponse fetchAllUsers() {
        /*
         * try { response.setUsers(getUserDao().fetchAllUsers()); } catch
         * (Exception e) { response.setSuccess(false);
         * response.setErrorMessage(e.getClass() + ": " + e.getMessage()); }
         */

        UserResponse response = new UserResponse();

        User testUser = createTestUser();

        List<User> users = new ArrayList<>();
        users.add(testUser);

        response.setUsers(users);

        return response;
    }

    /**
     * Test Data.
     *
     * @return user
     */
    private User createTestUser() {
        User testUser = new User();
        testUser.setName("El Colo Chacra");
        testUser.setBirthDate(new Date(System.currentTimeMillis()));
        testUser.setCity("Bulon");
        testUser.setId(00);
        testUser.setState("El bajo");
        return testUser;
    }

}
