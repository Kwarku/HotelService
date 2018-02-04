package pl.narodzinyprogramisty.view;

public interface AppUI {
    void greeting();

    int menu();

    void farewell();

    void menuError();

    void error(String msg);

}
