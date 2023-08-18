package presenter;

import model.*;
import view.*;

public class Presenter {

    private Functionalities functionalities;
    private AccountOperations accountOperations;
    private Account account;
    private BDmanager bDmanager;
    private ViewManager viewManager;

    public Presenter() {
        this.viewManager = new ViewManager();
        init();
    }

    public void init(){
        
    }
    
}
