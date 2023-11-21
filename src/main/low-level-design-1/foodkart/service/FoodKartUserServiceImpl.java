package foodkart.service;

import foodkart.dao.UserDao;
import foodkart.enums.Gender;
import foodkart.model.User;

public class FoodKartUserServiceImpl implements FoodKartUserService {

    UserDao userDao;

    public FoodKartUserServiceImpl() {
        this.userDao = UserDao.getInstance();
    }

    @Override
    public void registerUser(String name, String gender, String phoneNumber, String pinCode) {
        User user = new User(name, gender.toLowerCase().equals("male") ? Gender.MALE : Gender.FEMALE, phoneNumber,
                pinCode);
        userDao.addUser(user);
    }

    @Override
    public boolean loginUser(String userId) {
        User user = userDao.getUser(userId);
        if (user != null) {
            userDao.setCurrentLoginUser(user);
            return true;
        }
        return false;
    }
}
