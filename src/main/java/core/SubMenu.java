package core;

public enum SubMenu {
    TOOL_TIP("Tooltip"),
    ALERT_BOX("AlertBox"),
    DATE_PICKER("DatePicker"),
    DIALOG_BOXES("Dialog Boxes"),
    PROGRESS_BAR("Progress Bar"),
    DRAG_AND_DROP("Drag And Drop"),
    DRAGGABLE_BOXES("Draggable Boxes"),
    DROPDOWN_MENU("DropDown Menu"),
    TOOL_BAR("Toolbar"),
    AUTO_COMPLETE("Auto Complete"),
    ACCORDION_AND_TABS("Accordion And Tabs"),
    SELECT_ELEMENTS("Select Elements"),
    FRAMES_AND_WINDOWS("Frames And Windows");

    private final String SubMenu;

    SubMenu(String s) {
        this.SubMenu = s;
    }

    public String getSubMenu() {
        return this.SubMenu;
    }
}
