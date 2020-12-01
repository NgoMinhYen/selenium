package core;

public enum Menu {

    DEMO("Demo Testing Site"),
    ANGULAR("AngularJS Protractor Practice Site"),
    SAMPLE("Sample Page Test"),
    FLASH("Flash Website");

    private final String Menu;

    Menu(String s) {
        this.Menu = s;
    }

    public String getMenu() {
        return this.Menu;
    }
}
