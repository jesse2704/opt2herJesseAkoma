package src;

abstract class Authenticatie {

    public abstract Boolean checkUsername(String username);
    public abstract Boolean checkPassword(String password);

    public Boolean Authentication(String username, String password){
        if(checkUsername(username) && checkPassword(password)){
            return true;
        }
        return false;
    }
}
